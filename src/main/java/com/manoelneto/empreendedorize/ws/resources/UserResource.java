package com.manoelneto.empreendedorize.ws.resources;


import com.manoelneto.empreendedorize.ws.domain.Role;
import com.manoelneto.empreendedorize.ws.domain.User;
import com.manoelneto.empreendedorize.ws.dto.UserDto;
import com.manoelneto.empreendedorize.ws.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    UserService userService;

    TokenStore tokenStore = new InMemoryTokenStore();

    @Autowired
    DefaultTokenServices tokenServices = new DefaultTokenServices();

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> users = userService.findAll();
        List<UserDto> listDTO = users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User user = userService.findByID(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }
    @PostMapping("/users")
    public ResponseEntity<UserDto> create(@RequestBody UserDto UserDto) {
        User user = userService.fromDTO(UserDto);
        return ResponseEntity.ok().body(new UserDto(userService.create(user)));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> update(@PathVariable String id, @RequestBody UserDto UserDto) {

        User user = userService.fromDTO(UserDto);
        user.setId(id);
        return ResponseEntity.ok().body(new UserDto(userService.update(user)));
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/users/{id}/roles")
    public ResponseEntity<List<Role>> findRoles(@PathVariable String id ){
        User user = userService.findByID(id);

        return ResponseEntity.ok().body(user.getRoles());
    }

    @GetMapping(value="/users/main")
    public ResponseEntity<UserDto> getUserMain(Principal principal){
        User user = this.userService.findByEmail(principal.getName());
        UserDto userDto = new UserDto(user);
        userDto.setPassword("");
        return  ResponseEntity.ok().body(userDto);
    }

    @GetMapping(value = "/logout") public ResponseEntity<Void>  logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null){
            String tokenValue = authHeader.replace("Bearer", "").trim();
            OAuth2AccessToken accessToken = tokenServices.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
            tokenServices.revokeToken(String.valueOf(accessToken));
        }
        return ResponseEntity.noContent().build();
    }
}
