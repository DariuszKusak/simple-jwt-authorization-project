package com.kusak.dariusz.simplejwtauthorizationproject.config;

import com.kusak.dariusz.simplejwtauthorizationproject.security.JwtConfigurer;
import com.kusak.dariusz.simplejwtauthorizationproject.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final JwtTokenProvider jwtTokenProvider;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/signing").permitAll()
                .antMatchers("/api/v1/admin").hasAuthority("ADMIN")
                .antMatchers("/api/v1/manager").hasAuthority("MANAGER")
                .antMatchers("/api/v1/commonUser").hasAuthority("COMMON_USER")
                .antMatchers("/users").denyAll()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));

    }

}
