package com.mes.jss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mes.jss.security.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity // security filter 설정과 같음
public class SecurityConfig {

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new  BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((requests) -> 
			requests.antMatchers("/top", "/login" ,"/logout").permitAll()
						.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
						.anyRequest().authenticated())
			     .formLogin(login-> login.loginPage("/login")
			    		 							.usernameParameter("userid")
			    		 							.successHandler(successHandler()))			     									
			     .logout(logout-> logout.logoutUrl("/logout").logoutSuccessUrl("/top"))
				 // .csrf().disable()
				 ;
			
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**");
	}
}
