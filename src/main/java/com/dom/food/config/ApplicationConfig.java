package com.dom.food.config;

import com.dom.food.filter.JwtAuthenticationFilter;
import com.dom.food.filter.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Slf4j
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

    // private final UserDetailsService userDetailsService;
    // private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDetailsService userDetailsService;
    // @Autowired
    // BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // we define how spring look for the user authentication
        // in this case we use user detail service
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManagerBean());
        jwtAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.cors().and().csrf().disable();
        // stateless mean no session will be created or used by spring security
        // we used token in this case
        // http.authorizeRequests().antMatchers("/api/v1/login/**",
        // "/api/v1/register/**", "/api/v1/products/**").permitAll();
        // http.authorizeRequests().antMatchers("/api/role/save").hasAuthority("ADMIN");
        // http.authorizeRequests().antMatchers("/api/product/**").hasAnyAuthority("ADMIN",
        // "SALOR");
        // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // http.authorizeRequests().anyRequest().authenticated();

        http.anonymous()
                .and()
                .authorizeRequests()
                // .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll();

        http.addFilter(jwtAuthenticationFilter);
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
