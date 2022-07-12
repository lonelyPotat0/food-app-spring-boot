package com.dom.food.config;

import com.dom.food.filter.JwtAuthenticationFilter;
import com.dom.food.filter.JwtAuthorizationFilter;
import com.google.common.util.concurrent.RateLimiter;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;



// @Slf4j
// @Configuration
// @RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

    // private final UserDetailsService userDetailsService;
    // private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDetailsService userDetailsService;
    // @Autowired
    // BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public RateLimiter rateLimiter(){
        return  RateLimiter.create(1, Duration.ofSeconds(10));
    }
    
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManagerBean());
        jwtAuthenticationFilter.setFilterProcessesUrl("/api/login");

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/login", "/user/create").permitAll()
                .antMatchers("/review/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_OWNER", "ROLE_CUSTOMER")
                .antMatchers("/order/cart/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_OWNER", "ROLE_CUSTOMER")
                .antMatchers("/order/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_OWNER")
                .antMatchers("/order/confirm-delivered/**").hasAnyAuthority("ROLE_DELIVERY")
                .antMatchers("/user/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_OWNER", "ROLE_CUSTOMER", "ROLE_DELIVERY")
                .antMatchers("/shop/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_OWNER", "ROLE_DELIVERY")
                .antMatchers(HttpMethod.GET, "/shop/**").hasAnyAuthority("ROLE_CUSTOMER")
                .antMatchers("/category/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_OWNER", "ROLE_CUSTOMER", "ROLE_DELIVERY")
                .antMatchers("/menu/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_OWNER", "ROLE_DELIVERY")
                .antMatchers(HttpMethod.GET, "/menu/**").hasAnyAuthority("ROLE_CUSTOMER")
                .anyRequest().authenticated()
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
