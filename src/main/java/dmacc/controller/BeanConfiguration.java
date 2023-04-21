/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Apr 2, 2023
 */
package dmacc.controller;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Activities;
import dmacc.beans.Customer;
import dmacc.beans.Resort;
import dmacc.beans.Vacations;

@Configuration
public class BeanConfiguration {
	@Bean
	public Customer customer() {
		Customer bean = new Customer(); 
		return bean;
	}
	
	@Bean
	public Resort resort() {
		Resort bean = new Resort();
		return bean;
	}
	
	@Bean
	public Activities activites() {
		Activities bean = new Activities(); //("Boston Self Guided Tour", "Tour", 7.99);
		return bean;
	}
	
	@Bean
	public Vacations vacations() {
		Vacations bean = new Vacations();
		return bean;
	}
	
	@Bean
	public DataSource getDataSource() {
		return DataSourceBuilder.create()
				 .driverClassName("com.mysql.cj.jdbc.Driver")
		          .url("jdbc:mysql://localhost:3306/vacationplanner?useSSL=false")
		          .username("root")
		          .password("")
		          .build();	
	}
}
