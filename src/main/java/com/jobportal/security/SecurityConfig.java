package com.jobportal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService uds;
	
	@Bean
	public AuthenticationProvider ap() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(uds);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return provider;
	}
	

	@Bean
	public SecurityFilterChain sfc(HttpSecurity sec) throws Exception {
		
		sec.authorizeHttpRequests(req->req.anyRequest().authenticated());
		sec.csrf(csrf->csrf.disable());
		//sec.formLogin(Customizer.withDefaults());
		sec.httpBasic(Customizer.withDefaults());
		sec.sessionManagement(ses->ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return sec.build();
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder(12);
	}
	
//	@Bean
//	public UserDetailsService usc() {
//		
//		UserDetails user1=User.withDefaultPasswordEncoder()
//				.username("Rakoz")
//				.password("R123")
//				.roles("USER")
//				.build();
//		
//		UserDetails user2=User.withDefaultPasswordEncoder()
//				.username("Jakoz")
//				.password("J123")
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
}
