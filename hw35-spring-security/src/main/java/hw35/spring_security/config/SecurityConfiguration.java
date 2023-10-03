package hw35.spring_security.config;

import hw35.spring_security.auth.BasicAuthEntryPoint;
import hw35.spring_security.enums.UserRole;
import hw35.spring_security.repo.UserRepository;
import hw35.spring_security.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(reqs-> reqs
                .requestMatchers(antMatcher("/register"), antMatcher("/login"),
                        antMatcher("/ping")).permitAll()

        );

        http.authorizeHttpRequests(reqs-> reqs
                .requestMatchers(antMatcher(HttpMethod.POST, "/products"), antMatcher(HttpMethod.DELETE, "/products/*"))
               .hasRole(UserRole.ADMIN.toString())
                .anyRequest().authenticated()
        );

        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(basic->basic.authenticationEntryPoint(new BasicAuthEntryPoint()));
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        return new AppUserDetailsService(userRepository);

    }

}
