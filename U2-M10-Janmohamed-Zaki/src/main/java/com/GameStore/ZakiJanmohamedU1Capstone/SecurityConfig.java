package com.GameStore.ZakiJanmohamedU1Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username = ?")
                .passwordEncoder(encoder);

    }

    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.PUT,"/console/{console_id}").hasAnyAuthority("ROLE_STAFF","ROLE_MANAGER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.PUT,"/game/{game_id}").hasAnyAuthority("ROLE_STAFF","ROLE_MANAGER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.PUT,"/t_shirt/{id}").hasAnyAuthority("ROLE_STAFF","ROLE_MANAGER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST,"/console").hasAnyAuthority("ROLE_MANAGER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST,"/game").hasAnyAuthority("ROLE_MANAGER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST,"/t_shirt").hasAnyAuthority("ROLE_MANAGER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/t_shirt/delete/{t_shirt_id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/console/delete/{console_id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/game/delete/{game_id}").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll();

        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());


    }
}
