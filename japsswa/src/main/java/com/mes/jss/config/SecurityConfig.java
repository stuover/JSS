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
			requests.antMatchers("/top", "/login", "/logout").permitAll() // 공통 
						.antMatchers("/bomManager").hasAuthority("ROLE_ADMIN") // 전체 관리자
						.antMatchers("/insertorder", "/finished", "/release", "/return").hasAnyAuthority("ROLE_ADMIN", "SAL_ADMIN") // 영업
						.antMatchers("/facility", "/downtime", "/inspection").hasAnyAuthority("ROLE_ADMIN", "FAC_ADMIN") // 설비
						.antMatchers("/planManage", "/workManage", "/performanceManage").hasAnyAuthority("ROLE_ADMIN", "PRO_ADMIN") // 생산
						.antMatchers("/mrlist", "/mslist", "/mrOrder", "/mrReturn", "/mrAdjustment").hasAnyAuthority("ROLE_ADMIN", "MAT_ADMIN") // 자재
						.antMatchers("/quality", "/errQuality", "/passQuality").hasAnyAuthority("ROLE_ADMIN", "QUA_ADMIN") // 품질
						.anyRequest().authenticated())
			     .formLogin(login-> login.loginPage("/login")
			    		 							.usernameParameter("empNo")
			    		 							.successHandler(successHandler()))			     									
			     .logout(logout-> logout.logoutUrl("/logout").logoutSuccessUrl("/login"))
				 // .csrf().disable()
				 ;
			
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	
		return (web) -> web.ignoring().antMatchers("/static/**","/fonts/**","/partials/**","/scss/**","/vendors/**", "/images/**", "/js/**", "/css/**");
	}
}
