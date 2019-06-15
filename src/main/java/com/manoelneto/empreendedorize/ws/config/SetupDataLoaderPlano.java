package com.manoelneto.empreendedorize.ws.config;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.Role;
import com.manoelneto.empreendedorize.ws.repository.PlanoRepository;
import com.manoelneto.empreendedorize.ws.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Arrays;
import java.util.Optional;

@Configuration
public class SetupDataLoaderPlano implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        planoRepository.deleteAll();
        roleRepository.deleteAll();

        Role roleDono = createRoleIfNotFound("DONO");
        Role roleConvidado = createRoleIfNotFound("CONVIDADO");

        Plano papelaria = new Plano(null,"Abrir papelaria","20/05/2020","Empreendedorismo");
        Plano acougue = new Plano(null,"Abrir açougue","20/05/2030","Empreendedorismo");

        papelaria.setRoles(Arrays.asList(roleDono));
        acougue.setRoles(Arrays.asList(roleConvidado));

        planoRepository.save(papelaria);
        planoRepository.save(acougue);

    }

    private Role createRoleIfNotFound(String name){
        Optional<Role> role = roleRepository.findByName(name);
        if(role.isPresent()){
            return role.get();
        }
        return roleRepository.save(new Role(name));
    }
}
