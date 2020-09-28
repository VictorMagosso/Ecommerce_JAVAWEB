package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminServiceImpl)
                .passwordEncoder(new BCryptPasswordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	    http.csrf().disable().authorizeRequests()
	            .antMatchers(HttpMethod.GET, "/").permitAll()
	            .antMatchers(HttpMethod.GET, "/newproduto").hasRole("ADMIN")
	            .antMatchers(HttpMethod.POST, "/newproduto").hasRole("ADMIN")
	            .anyRequest().authenticated()
	            .and().formLogin().permitAll();
//	            .and().logout().invalidateHttpSession(true)
//	            .and().logout().clearAuthentication(true)
//	            .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//	            .logoutSuccessUrl("/login?logout")
//	            .permitAll();
	    
	    
	    }
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/materialize/", "/styles/**");
	}

   }
    

	 
