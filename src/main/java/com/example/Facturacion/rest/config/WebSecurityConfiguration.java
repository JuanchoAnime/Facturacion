package com.example.Facturacion.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.Facturacion.domain.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	private final UserService userService;
	private final String tokenSecurity;
	
	@Autowired
	public WebSecurityConfiguration(UserService userService,
			@Value("${security.key}") String tokenSecurity) {
		this.userService = userService;
		this.tokenSecurity = tokenSecurity;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/api/user").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(new LoginFilter("/login", authenticationManager(), tokenSecurity), 
					UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new JwtFilter(tokenSecurity), UsernamePasswordAuthenticationFilter.class);
	}
}
