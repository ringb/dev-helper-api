package app.helper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http
            .httpBasic().and() // needed??
            .authorizeRequests()
                .antMatchers("/","/users","/createUser")
                .permitAll().anyRequest().authenticated()
            .and().csrf().disable();

/*
  TODO old security with redirect to login. did not work for /createUser POST. remove?
        http
            .authorizeRequests()
                .antMatchers( "/content", "/users", "/createUserGet", "/createUser").permitAll()
                *//*.antMatchers(HttpMethod.POST, "/createUser").permitAll()*//*
                .anyRequest().authenticated()
            .and()
              .formLogin()
              .loginPage("/login") // or e.g. "http://app.dev-helper.org/"
              .permitAll()
            .and()
              .logout()
              .permitAll();*/
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}