package com.megatech.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	private static String REALM = "MegaTech Control";

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("mega").password("mega").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("karpov").password("karpov").roles("API");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic();
		// http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/admin**").access("hasRole('ADMIN')")
		// .antMatchers("/view/*").access("hasRole('ADMIN')").and().formLogin().loginPage("/login")
		// .failureUrl("/login?error").usernameParameter("user").passwordParameter("pass").and().logout()
		// .logoutSuccessUrl("/login?logout").invalidateHttpSession(true).and().csrf();

	}

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	//
	// http.csrf().disable().authorizeRequests().antMatchers("/view/**").hasRole("ADMIN").and().httpBasic()
	// .realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint()).and().sessionManagement()
	// .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	// }

//	@Bean
//	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
//		return new CustomBasicAuthenticationEntryPoint();
//	}
//
//	// @Override
//	// public void configure(WebSecurity web) throws Exception {
//	// web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//	//
//	// }
//
//	@Configuration
//	@Order(1)
//	public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable().antMatcher("/view/**").authorizeRequests().anyRequest().hasAnyRole("ADMIN", "API")
//					.and().httpBasic();
//		}
//	}
//
//	@Configuration
//	@Order(2)
//	public static class FormWebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//		@Override
//		public void configure(WebSecurity web) throws Exception {
//			web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
//		}
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable() // HTTP with Disable CSRF
//					.authorizeRequests().antMatchers("/rest/**").permitAll().antMatchers("/view/**").hasRole("ADMIN")
//					.anyRequest().authenticated().and().formLogin().loginPage("/login").failureUrl("/login?error")
//					.usernameParameter("user").passwordParameter("pass").and().logout()
//					.logoutSuccessUrl("/login?logout").permitAll();
//		}
//	}
}
