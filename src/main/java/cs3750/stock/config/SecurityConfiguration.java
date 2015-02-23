package cs3750.stock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);

	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/static/**").permitAll()
	    .anyRequest().permitAll() //.authenticated()
	    .and()
		// disable cross-site scripting 
		.csrf().disable();
		
		
	}
	
	
	
	
	

}
