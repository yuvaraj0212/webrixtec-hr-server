package webrixtec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class configuration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin@123").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/user").hasAnyRole("USER","ADMIN").antMatchers("/admin").hasRole("ADMIN")
//	.antMatchers("/").permitAll().and().formLogin();
		http.authorizeRequests().antMatchers("/").permitAll().and().httpBasic();
	}

	@Bean
	public static NoOpPasswordEncoder encoder() {
		// TODO Auto-generated method stub
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
