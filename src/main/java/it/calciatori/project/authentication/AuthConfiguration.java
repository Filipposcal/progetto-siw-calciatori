package it.calciatori.project.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import static it.calciatori.project.model.Credentials.ADMIN_ROLE;

@Configuration
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource datasource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,  "/resources/**", "/static/**","/webjars/**","/",
                        "/index.html", "/login","/welcome", "/register", "/css/**", "/images/**",
                        "/contacts","/calciatori","/squadre","/allenatori","/procuratori","/campionati").permitAll()
                .antMatchers(HttpMethod.POST, "/login", "/register").permitAll()
                .antMatchers(HttpMethod.GET, "/admin/**").hasAnyAuthority(ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/admin/**").hasAnyAuthority(ADMIN_ROLE)
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/default",true)
                .and()
                .httpBasic();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(this.datasource)
                .authoritiesByUsernameQuery("SELECT username, role FROM credentials WHERE username=?")
                .usersByUsernameQuery("SELECT username, password, 1 as enabled FROM credentials WHERE username=?");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
