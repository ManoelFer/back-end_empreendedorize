package com.manoelneto.empreendedorize.ws.config;

import com.manoelneto.empreendedorize.ws.domain.Role;
import com.manoelneto.empreendedorize.ws.domain.User;
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
public class SetupDataLoaderUsu implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        userRepository.deleteAll();
        roleRepository.deleteAll();
        verificationTokenRepository.deleteAll();

        Role roleAdmin = createRoleIfNotFound("ROLE_ADMIN");
        Role roleUser = createRoleIfNotFound("ROLE_USER");

        User manoel = new User("06365448180", "Manoel Fernandes", "Neto", "manoelfernandes15@gmail.com");

        manoel.setRoles(Arrays.asList(roleAdmin));
        manoel.setPassword(passwordEncoder.encode("87654321"));
        manoel.setEnabled(true);

        createUserIfNotFound(manoel);
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
        if (role.isPresent()){
            return role.get();
        }
        return roleRepository.save(new Role(name));
    }

}
