package es.tintomax.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/home").permitAll();
        http.authorizeRequests().antMatchers("/listado_precios").permitAll();
        http.authorizeRequests().antMatchers("/localizacion").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
	
        
        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/servicios_cliente").hasAnyRole("CLIENT");
        http.authorizeRequests().antMatchers("/datos_usuario").hasAnyRole("CLIENT", "EMPLOYEE");
        http.authorizeRequests().antMatchers("/editar_usuario").hasAnyRole("CLIENT", "EMPLOYEE");
        http.authorizeRequests().antMatchers("/administracion").hasAnyRole("ADMIN");
        
        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().failureUrl("/loginerror");
        
        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/home");

    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
