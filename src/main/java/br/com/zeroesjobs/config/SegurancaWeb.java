package br.com.zeroesjobs.config;

import br.com.zeroesjobs.services.DadosUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SegurancaWeb {

    private final DadosUsuarioService dadosUsuarioService;
    private final Autenticacao autenticacao;

    @Autowired
    public SegurancaWeb(DadosUsuarioService dadosUsuarioService, Autenticacao autenticacao) {
        this.dadosUsuarioService = dadosUsuarioService;
        this.autenticacao = autenticacao;
    }

    private final String[] endpointUrl = {
            "/",
            "/pesquisar",
            "/cadastrar",
            "/cadastrar/**",
            "/webjars/**",
            "/resources/**",
            "/assets/**",
            "/css/**",
            "/fonts**",
            "/favicon.ico",
            "/resources/**",
            "/error"
    };

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authenticationProvider(provedorDeAutenticacao());

        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers(endpointUrl).permitAll();
            auth.anyRequest().authenticated();
        });

        http.formLogin(
                form->form.loginPage("/login").permitAll()
                        .successHandler(autenticacao))
                        .logout(logout-> {
                            logout.logoutUrl("/logout");
                            logout.logoutSuccessUrl("/");
                        }).cors(Customizer.withDefaults())
                        .csrf(csrf->csrf.disable());

        return http.build();
    }

    @Bean
    public AuthenticationProvider provedorDeAutenticacao() {
        DaoAuthenticationProvider provedorDeAutenticacao = new DaoAuthenticationProvider();
        provedorDeAutenticacao.setPasswordEncoder(codificadorDeSenhas());
        provedorDeAutenticacao.setUserDetailsService(dadosUsuarioService);
        return provedorDeAutenticacao;
    }

    @Bean
    public PasswordEncoder codificadorDeSenhas() {
        return new BCryptPasswordEncoder();
    }
}
