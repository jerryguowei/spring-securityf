package com.duduanan.springsecurity.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages="com.duduanan.springsecurity")
public class AppConfig implements WebMvcConfigurer{
	private Environment env;
	
	@Bean 
	public DataSource securityDataSource(){
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("mysql.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl(env.getProperty("mysql.jdbcUrl"));
		dataSource.setUser(env.getProperty("mysql.username"));
		dataSource.setPassword(env.getProperty("mysql.password"));
		dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
	    dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));	
	    dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
	    return dataSource;
	}
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		        .addResourceLocations("/resources/")
		         .setCachePeriod(31556926);
	}
}
