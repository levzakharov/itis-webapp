package com.itis.config;

import com.itis.utils.ApplicationUrls;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourcesConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers(ApplicationUrls.ApiUrls.BASE_API_URL + "/**")
                .and()
                .authorizeRequests()
                .antMatchers(ApplicationUrls.ApiUrls.BASE_USERS_URL).permitAll()
                .antMatchers(ApplicationUrls.ApiUrls.BASE_NEWS_URL).permitAll()
                .anyRequest().authenticated();
    }
}