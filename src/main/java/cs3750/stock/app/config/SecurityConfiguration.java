package cs3750.stock.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);

	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
		// don't secure these routes
        .authorizeRequests()
            .antMatchers("/", "/home", "/static/**", "/doLogin", "/registration", "/doregistration").permitAll()
            .anyRequest().authenticated()
            .and()
        // use form login
        .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/doLogin")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/successfulLogin", true)
            .permitAll()
            .and()
        .logout()
        	.logoutUrl("/logout")
            .permitAll()
            .and()
        .csrf().disable();
		
		
	}
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username, password, true as enabled from stocks.users where username=?")
			.authoritiesByUsernameQuery("select username, 'USER' as role from stocks.users where username=?");
    }

}
