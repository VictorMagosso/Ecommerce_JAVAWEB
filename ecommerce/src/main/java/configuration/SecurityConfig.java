package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.cadastro.ecommerce.service.serviceImpl.AdminServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	private static final String[] AUTH_LIST = {
	        "/newproduto",
	        "/meusprodutos"
	    };
	private static final String[] PUBLIC_AREAS = {
			"/",
			"/registration",
			"/produtos"
		};
	    @Override
	    protected void configure(HttpSecurity http) throws Exception{
	        http.authorizeRequests()
	                .antMatchers(AUTH_LIST).permitAll()
	                .anyRequest().authenticated()
	                .and().formLogin().loginPage("/login").permitAll()
	                .and().logout().invalidateHttpSession(true)
	                .and().logout().clearAuthentication(true)
	                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                .logoutSuccessUrl("/login?logout")
	                .permitAll();
	        	
	    }
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(adminServiceImpl)
	                .passwordEncoder(new BCryptPasswordEncoder());
		}
   }
    

	 
