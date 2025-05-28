package com.bikes.PontoEletronico.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // indica que a classe usa configurações do Spring
@EnableWebSecurity // Ativa a segurança web do Spring Security
public class SecurityConfig { // *Classe

    @Bean // Cria um objeto gerenciado pelo Spring. Isso são os Bean's
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // *Método
        http
                .csrf().disable() // desabilita a proteção CSRF
                .authorizeRequests() // Início da configuração de regras de acesso
                .antMatchers("/api/auth/**").permitAll() // Define URL's específicas e suas permissões
                .anyRequest().authenticated() // Faz com que todas as outras URL's exijam autenticação
                .and()
                .httpBasic(); //Ativa a autenticação básica: Usuário/senha

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() { //*Método
        UserDetails user = User.builder() //Define o método de gerenciamento de funcionários
                .username("funcionario")
                .password(passwordEncoder().encode("123456"))
                .roles("FUNCIONARIO")
                .build();

        UserDetails admin = User.builder() //Define o método de gerenciamento de administradores
                .username("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin); //Armazena usuários na memória ao invés do banco (Vai necessitar a troca)
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } //*Método que codifica as senhas para armazenamento seguro
}