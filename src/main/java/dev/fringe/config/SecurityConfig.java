package dev.fringe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.SneakyThrows;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	@SneakyThrows
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user")
				.password(passwordEncoder.encode("123456")).roles("USER").and().withUser("admin")
				.password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@SneakyThrows
	protected void configure(HttpSecurity http) {
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/**").hasAnyRole("ADMIN", "USER").and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?error=true").permitAll()
				.and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll().and()
				.csrf().disable();
	}
}
