package com.manoelneto.empreendedorize.ws.security.oauth2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;


@Configuration
@EnableResourceServer
@Api(description = "Configuração das permições de usuários.")
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "restservice";


    @Override public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(this.RESOURCE_ID);
    }

    @ApiOperation("Limitar o acesso a determinados caminhos que podem ser acessados por admin ou usuário!")
    @Override public void configure(HttpSecurity http) throws Exception {
        http.
                logout().logoutSuccessUrl("/").permitAll()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .and().authorizeRequests()
                .antMatchers("/api/users/**").hasAnyRole("ADMIN")
                .antMatchers("/api/planos/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().denyAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}

