package com.manoelneto.empreendedorize.ws.resources;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.Role;
import com.manoelneto.empreendedorize.ws.domain.User;
import com.manoelneto.empreendedorize.ws.dto.PlanoDto;
import com.manoelneto.empreendedorize.ws.services.PlanoService;
import com.manoelneto.empreendedorize.ws.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PlanoResource {

    @Autowired
    UserService userService;

    @Autowired
    PlanoService planoService;

    @GetMapping("/planos")
    public ResponseEntity<List<PlanoDto>> findAll(Principal principal) {
        User user = this.userService.findByEmail(principal.getName());
        List<Plano> planos = planoService.findAll(user);
        List<PlanoDto> listDto = planos.stream().map(x -> new PlanoDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/planos/{id}")
    public ResponseEntity<PlanoDto> findById(@PathVariable String id){
        Plano plano = planoService.findByID(id);
        return ResponseEntity.ok().body(new PlanoDto(plano));
    }

    @PostMapping("/planos")
    public ResponseEntity<PlanoDto> create(@RequestBody PlanoDto planoDto){
        Plano plano = planoService.fromDTO(planoDto);
        return  ResponseEntity.ok().body(new PlanoDto(planoService.create(plano)));
    }

    @PutMapping("/planos/{id}")
    public ResponseEntity<PlanoDto> update(@PathVariable String id, @RequestBody PlanoDto planoDto) {
        Plano plano = planoService.fromDTO(planoDto);
        plano.setId(id);
        return ResponseEntity.ok().body(new PlanoDto(planoService.update(plano)));
    }

    @DeleteMapping("/planos/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        planoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/planos/{id}/roles")
    public ResponseEntity<List<Role>> findRoles(@PathVariable String id){
        Plano plano = planoService.findByID(id);
        return ResponseEntity.ok().body(plano.getRoles());
    }
}
