package me.joshua.ming_board_villege.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

//    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .headers().frameOptions().disable()
//                .and()
//                    .authorizeRequests()
//                .antMatchers("/", "/css/**", "/images/**", "/js/**","/auth/**").permitAll()
//                .antMatchers("/boards/**").hasRole(Ro)
    }

}

