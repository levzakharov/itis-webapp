package com.itis.config;

import com.itis.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.itis.utils.ApplicationUrls.WebAppUrls.BASE_NEWS_URL;
import static com.itis.utils.ApplicationUrls.WebAppUrls.SIGN_IN;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage(SIGN_IN).permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl(BASE_NEWS_URL)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v2/users").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}

