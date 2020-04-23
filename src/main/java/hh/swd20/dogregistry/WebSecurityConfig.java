package hh.swd20.dogregistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.swd20.dogregistry.webcontrol.UserDetailServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    
        http
        .authorizeRequests()
        	.antMatchers("/css/**", "/login", "/index", "/doglist","/breedlist","/breedgrouplist","/dogs/**","/breeds/**").permitAll()
        	.and()
        
        .authorizeRequests().anyRequest().authenticated()
        .and().csrf().disable()
      .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/index")
          .permitAll()
          .and()
      .logout()
          .permitAll();
    	
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}