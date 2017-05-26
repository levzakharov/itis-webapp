package com.itis.config;

import com.itis.security.CustomUserDetailsService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.itis.utils.ApplicationUrls.WebAppUrls.LOGIN;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

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
                .loginPage(ApplicationUrls.WebAppUrls.LOGIN)
                .permitAll()
                .passwordParameter("password")
                .usernameParameter("login")
                .loginProcessingUrl(ApplicationUrls.WebAppUrls.LOGIN + "/process")
                .defaultSuccessUrl(ApplicationUrls.WebAppUrls.BASE_NEWS_URL)
                .failureUrl(LOGIN + "?error=true")
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .antMatchers(LOGIN + "**").permitAll()
                .antMatchers(ApplicationUrls.ApiUrls.BASE_USERS_URL).permitAll()
                .antMatchers(ApplicationUrls.ApiUrls.BASE_NEWS_URL).permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
        ;
    }

    @Override
    public void configure(WebSecurity security){
        security.ignoring().antMatchers("/fonts/**");
    }
}