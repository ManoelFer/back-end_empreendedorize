package com.manoelneto.empreendedorize.ws.config;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.Role;
import com.manoelneto.empreendedorize.ws.domain.User;
import com.manoelneto.empreendedorize.ws.repository.PlanoRepository;
import com.manoelneto.empreendedorize.ws.repository.RoleRepository;
import com.manoelneto.empreendedorize.ws.repository.UserRepository;
import com.manoelneto.empreendedorize.ws.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Optional;


@Configuration
public class SetupDataLoaderPlano implements ApplicationListener<ContextRefreshedEvent> {

    public User heitor ;
    public User juam ;

    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        planoRepository.deleteAll();
        roleRepository.deleteAll();
        iniciaDados();

        Role roleDono = createRoleIfNotFound("ROLE_DONO");
        Role roleConvidado = createRoleIfNotFound("ROLE_CONVIDADO");

        Plano papelaria = new Plano(heitor,"Abrir papelaria","20/05/2020","Empreendedorismo");
        Plano acougue = new Plano(juam,"Abrir açougue","20/05/2030","Empreendedorismo");
        Plano cabare = new Plano(juam, "cabaré", "20/08/2020", "Empreendedorismo");

        papelaria.setRoles(Arrays.asList(roleDono));
        acougue.setRoles(Arrays.asList(roleConvidado));

        planoRepository.save(papelaria);
        planoRepository.save(acougue);
        planoRepository.save(cabare);

    }

    public void iniciaDados() {

        userRepository.deleteAll();
        roleRepository.deleteAll();
        verificationTokenRepository.deleteAll();

        Role roleAdmin = createRoleIfNotFound("ROLE_ADMIN");
        Role roleUser = createRoleIfNotFound("ROLE_USER");

        heitor = new User("06365448181", "Heitor", "Neves", "heitor@gmail.com");
        juam = new User("06365448181", "Juam", "Neto", "juam@gmail.com");

        heitor.setRoles(Arrays.asList(roleAdmin));
        heitor.setPassword(passwordEncoder.encode("123"));
        heitor.setEnabled(true);

        juam.setRoles(Arrays.asList(roleUser));
        juam.setPassword(passwordEncoder.encode("123"));
        juam.setEnabled(true);

        createUserIfNotFound(heitor);
        createUserIfNotFound(juam);
    }

    private User createUserIfNotFound(final User user) {
        Optional<User> obj = userRepository.findByEmail(user.getEmail());
        if(obj.isPresent()) {
            return obj.get();
        }
        return userRepository.save(user);
    }

    private Role createRoleIfNotFound(String name){
        Optional<Role> role = roleRepository.findByName(name);
        if(role.isPresent()){
            return role.get();
        }
        return roleRepository.save(new Role(name));
    }
}
