// Essa classe configura a segurança do sistema
// "COMO????"
// Definindo as regras de autenticação, configurando o JWT e gerenciando os acessos a endpoints

@Configuration //Esse tipo de anotação serve para fornecer metadados para o framework
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        .authorizeRequests()
        .antMatchers("/api/auth/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new JwtAuthenticationFilter(authenticationManager()))
        .addFilter(new JwtAuthorizationFilter(authenticationManager()))
    }
}