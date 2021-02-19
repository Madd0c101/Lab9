package jdev.server.ui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/img/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/home").authenticated()
                .antMatchers("/error").authenticated()
                .antMatchers("/routes").hasRole("CLIENT")
                .antMatchers("/payments").hasRole("CLIENT")
                .antMatchers("/registerClient").hasRole("MANAGER")
                .antMatchers("/registerManager").hasRole("ROOT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
               // .loginProcessingUrl("/home.hml").permitAll()
                .permitAll()
               // .loginProcessingUrl("/authentication").permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("Joe").password("0").roles("USER")
                .and()
                .withUser("John").password("000").roles("CLIENT","USER")
                .and()
                .withUser("Harry").password("123").roles("MANAGER", "CLIENT","USER")
                .and()
                .withUser("Walker").password("xxx").roles("ROOT", "MANAGER","CLIENT","USER");
    }
}
