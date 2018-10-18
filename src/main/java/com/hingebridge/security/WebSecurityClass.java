package com.hingebridge.security;

import com.hingebridge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration  //Means this class is a source of bean injection (e.g we used @Bean for the BCryptPasswordEncoder)
@EnableWebSecurity  //Means this is our applicationContext-security.xml configuration class in Java class format
@EnableGlobalMethodSecurity(prePostEnabled = true)  //Very important, if we want to use service layer security
public class WebSecurityClass extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserService userv;
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userv).passwordEncoder(getEnc());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception    //This will be my accepted pattern. It even uses lesser lines of code
    {
	http.authorizeRequests()
        .anyRequest().permitAll()   //permitAll request now because I am using service/business layer security
	.and()
        .formLogin()                                                            //Custom login form
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("user")
                .passwordParameter("pswd")
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
        .and()
        .logout().deleteCookies("remove").invalidateHttpSession(true)           //Logout command
        .logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/");
    }
    
    @Bean
    public BCryptPasswordEncoder getEnc()   //Password encryption: whatever password you input is encoded and compared with the one in
    {                                       //the database (i.e you must encode the password before saving to the database)
        return new BCryptPasswordEncoder();
    }
    
    
    /*METHOD 1
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
	http.authorizeRequests()
	.antMatchers("/").permitAll()
        .antMatchers("/user/**").hasRole("USER")    //.authenticated is same as .hasRole("whatever username") just that it does not
        .antMatchers("/admin/**").hasRole("ADMIN")  //specify any role to authenticate against
	.and()
        .formLogin()                                                            //Custom login form
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("user")
                .passwordParameter("pswd")
                .loginPage("/login").permitAll()
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
        .and()
        .logout().deleteCookies("remove").invalidateHttpSession(true)           //Logout command
        .logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/");
    }
    */
    
    /*METHOD 2
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
	http.authorizeRequests()
	.antMatchers("/").permitAll()
        .antMatchers("/user/**").authenticated()       //.authenticated is same as .hasRole("whatever username") just that it does not
        .antMatchers("/admin/**").authenticated()      //specify any role to authenticate against
	.and()
        .formLogin()                                                            //Custom login form
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("user")
                .passwordParameter("pswd")
                .loginPage("/login").permitAll()
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
        .and()
        .logout().deleteCookies("remove").invalidateHttpSession(true)           //Logout command
        .logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/");
    }*/
    
    /*@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
	.inMemoryAuthentication()
                .withUser("user").password("{noop}1111").roles("USER")          //using inMemoryAuthentication and testing username and
                .and()                                                          //password use {noop} before username and password so
                .withUser("admin").password("{noop}2222").roles("ADMIN");       //the encoder woud bypass them
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
	http.authorizeRequests()
	.antMatchers("/").permitAll()
        .antMatchers("/user/**").hasRole("USER")
        .antMatchers("/admin/**").hasRole("ADMIN")
	.and()
        .formLogin()                                                            //Custom login form
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("user")
                .passwordParameter("pswd")
                .loginPage("/login").permitAll()
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
        .and()
        .logout().deleteCookies("remove").invalidateHttpSession(true)           //Logout command
        .logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/");
    }*/
    
    /*Http Basic Form Login (no need for .formLogin())
    @Override
    protected void configure(HttpSecurity http) throws Exception                //For HttpBasic form login (i.e like a pop-up)
    {
	http
        .authorizeRequests()
        .antMatchers("/login").permitAll()
	.antMatchers("/").hasRole("USER")
	.and().httpBasic();	
    }*/
}