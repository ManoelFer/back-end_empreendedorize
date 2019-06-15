package com.manoelneto.empreendedorize.ws.resources;

import com.manoelneto.empreendedorize.ws.domain.User;
import com.manoelneto.empreendedorize.ws.dto.UserDto;
import com.manoelneto.empreendedorize.ws.resources.util.GenericResponse;
import com.manoelneto.empreendedorize.ws.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/public")
public class RegistrationResource {

    @Autowired
    UserService userService;

    @PostMapping("/registration/users")
    public ResponseEntity<Void> registerUser(@RequestBody UserDto userDto){

        User user = this.userService.fromDTO(userDto);
        this.userService.registerUser(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/regitrationConfirm/users")
    public ResponseEntity<GenericResponse> confirmRegistrationUser(@RequestParam("token") String token){
        final Object result = this.userService.validateVerificationToken(token);
        if (result == null){
            return ResponseEntity.ok().body(new GenericResponse("Success"));
        }
        return  ResponseEntity.status(HttpStatus.SEE_OTHER).body(new GenericResponse(result.toString()));
    }

    @GetMapping(value = "/resendRegistrationToken/users")
    public ResponseEntity<Void>  resendRegistrationToken( @RequestParam("email")  String email) {
        this.userService.generateNewVerificationToken(email);
        return ResponseEntity.noContent().build();
    }
}
