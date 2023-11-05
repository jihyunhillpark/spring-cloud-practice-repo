package com.example.userservice.security;

import com.example.userservice.service.CustomeUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final Environment env;
    private final CustomeUserDetailService userDetailsService;
    private final ObjectPostProcessor<Object> objectPostProcessor;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        http.csrf().disable();
        http.authorizeHttpRequests(request -> {
            try {
                request
                        .requestMatchers(mvcMatcherBuilder.pattern("/actuator/**")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/**")).permitAll()
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers(new IpAddressMatcher("127.0.0.1")).permitAll()
                        .and()
                        .addFilter(getAuthenticationFilter());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        http.headers().frameOptions().disable();
        return http.build();
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(env, userDetailsService);
        AuthenticationManagerBuilder builder = new AuthenticationManagerBuilder(objectPostProcessor);
        authenticationFilter.setAuthenticationManager(authenticationManager(builder));
        return authenticationFilter;
    }

    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        return auth.build();
    }
}
