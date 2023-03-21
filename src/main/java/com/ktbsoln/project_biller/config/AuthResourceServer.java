package com.ktbsoln.project_biller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;


@Configuration
@EnableResourceServer
public class AuthResourceServer extends ResourceServerConfigurerAdapter{
	private static final String RESOURCE_ID = "resource_id";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
        http
        		.cors().and()
        		.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/oauth/**").permitAll()
        		.antMatchers("/coreapi/**", "/login/**").permitAll()
        		.antMatchers("/test/**").access("hasRole('ADMIN')")
        		.antMatchers("/guest/**").access("hasRole('ADMIN')")
        		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
	
}
