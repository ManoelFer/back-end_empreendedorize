package com.manoelneto.empreendedorize.ws.config;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.Role;
import com.manoelneto.empreendedorize.ws.domain.User;
import com.manoelneto.empreendedorize.ws.domain.conclusao.AnaliseDoPlano;
import com.manoelneto.empreendedorize.ws.domain.introducao.*;
import com.manoelneto.empreendedorize.ws.repository.PlanoRepository;
import com.manoelneto.empreendedorize.ws.repository.RoleRepository;
import com.manoelneto.empreendedorize.ws.repository.UserRepository;
import com.manoelneto.empreendedorize.ws.repository.VerificationTokenRepository;
import com.manoelneto.empreendedorize.ws.repository.conclusao.AnaliseDoPlanoRepository;
import com.manoelneto.empreendedorize.ws.repository.introducao.*;
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

    public Plano papelaria;
    public Plano acougue;
    public Plano cabare;

    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    //-------------------- Repositorys Introdução ao plano ------------------------
    @Autowired
    DadosEmpreendedoresRepository dadosEmpreendedoresRepository;
    @Autowired
    MissaoDaEmpresaRepository missaoDaEmpresaRepository;
    @Autowired
    SetoresDeAtividadeRepository setoresDeAtividadeRepository;
    @Autowired
    CapitalSocialRepository capitalSocialRepository;
    @Autowired
    FonteDeRecursosRepository fonteDeRecursosRepository;
    //---------------------------------------------------------------------------------

    @Autowired
    AnaliseDoPlanoRepository analiseDoPlanoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        planoRepository.deleteAll();
        roleRepository.deleteAll();
        iniciaDadosUsu();

        Role roleDono = createRoleIfNotFound("ROLE_DONO");
        Role roleConvidado = createRoleIfNotFound("ROLE_CONVIDADO");

        papelaria = new Plano(heitor,"Abrir papelaria","20/05/2020","Empreendedorismo");
        acougue = new Plano(juam,"Abrir açougue","20/05/2030","Empreendedorismo");
        cabare = new Plano(juam, "cabaré", "20/08/2020", "Empreendedorismo");

        papelaria.setRoles(Arrays.asList(roleDono));
        acougue.setRoles(Arrays.asList(roleConvidado));

        planoRepository.save(papelaria);
        planoRepository.save(acougue);
        planoRepository.save(cabare);

        iniciaDadosSocios();
        iniciaMissao();
        iniciaSetores();
        iniciaCapitalSocial();
        iniciaFonteDeRecursos();
    }

    public void iniciaDadosUsu() {

        userRepository.deleteAll();
        roleRepository.deleteAll();
        verificationTokenRepository.deleteAll();

        Role roleAdmin = createRoleIfNotFound("ROLE_ADMIN");
        Role roleUser = createRoleIfNotFound("ROLE_USER");

        heitor = new User("06365448181", "Heitor", "Neves", "(64)999974757",
                "(64)999838239", "heitor@gmail.com", "Rua Major milhomens Nº904 Setor Nova Caiapônia"
                , "Caiapônia", "GO", "Advogado");
        juam = new User("06365448181", "Juam", "Neto", "(64)999974757",
                "(64)999838239", "juam@gmail.com", "Rua Major milhomens Nº904 Setor Nova Caiapônia"
                , "Caiapônia", "GO", "Advogado");

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

    public void iniciaDadosSocios(){
        dadosEmpreendedoresRepository.deleteAll();

        DadosEmpreendedores socio1 = new DadosEmpreendedores(papelaria,"Manoel","Rua major milhomens Nº904",
                "Caiapônia","GO","999974757","999838239", "manoelfernandes15@gmail.com",
                "Acadêmico ensino superior TADS", "recepcionista");

        dadosEmpreendedoresRepository.save(socio1);
    }
    public void iniciaMissao(){
        missaoDaEmpresaRepository.deleteAll();

        MissaoDaEmpresa venderPapel = new MissaoDaEmpresa(papelaria,"Vender papeis para caralho");

        missaoDaEmpresaRepository.save(venderPapel);
    }

    public void iniciaSetores(){
        setoresDeAtividadeRepository.deleteAll();

        SetoresDeAtividade comercio = new SetoresDeAtividade(papelaria, "comércio");

        setoresDeAtividadeRepository.save(comercio);
    }

    public void iniciaCapitalSocial(){
        capitalSocialRepository.deleteAll();

        CapitalSocial cemPorcento = new CapitalSocial(papelaria, 100.00);

        capitalSocialRepository.save(cemPorcento);
    }

    public  void iniciaFonteDeRecursos(){
        fonteDeRecursosRepository.deleteAll();

        FonteDeRecursos nheuMemu = new FonteDeRecursos(papelaria, "Recursos próprios");

        fonteDeRecursosRepository.save(nheuMemu);
    }

    public void iniciaConclusao(){
        analiseDoPlanoRepository.deleteAll();

        AnaliseDoPlano terminou = new AnaliseDoPlano(papelaria, "Foi muito bom fazer este plano");

        analiseDoPlanoRepository.save(terminou);
    }
}
