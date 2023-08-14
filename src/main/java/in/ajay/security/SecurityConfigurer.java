package in.ajay.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import in.ajay.service.MyUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
	
	//Logic implementation for UserDetailsService interface
	
	@Autowired
	private MyUserDetailsService userDtlsService;
	
	@Autowired
	public void configreUsers(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDtlsService)
			.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	

	//This is implementation of In Memory authentication which is out dated.
	/*@Bean
	public InMemoryUserDetailsManager configureUsers() {
		
		UserDetails adminUser = User.withDefaultPasswordEncoder()
									.username("ajay")
									.password("abc@123")
									.authorities("ADMIN")
									.build();
		
		UserDetails normalUser = User.withDefaultPasswordEncoder()
									 .username("jay")
									 .password("jay@123")
									 .authorities("USER")
									 .build();
		
		return new InMemoryUserDetailsManager(adminUser,normalUser);
	}  
	*/
	
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((req) ->
					                
        							req.antMatchers("/contact")
					                   .permitAll()
					                   .anyRequest()
					                   .authenticated()

        ).formLogin(withDefaults());
		
		return http.build();
	}
}
