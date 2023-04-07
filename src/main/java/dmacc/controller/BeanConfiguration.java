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

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Activities activites() {
		Activities bean = new Activities(); //("Boston Self Guided Tour", "Tour", 7.99);
		return bean;
	}
	
	/*@Bean
	public DataSource getDataSource() {
		return DataSourceBuilder.create()
				 .driverClassName("com.mysql.cj.jdbc.Driver")
		          .url("jdbc:mysql://localhost:3306/vacationplanner?useSSL=false")
		          .username("root")
		          .password("")
		          .build();	
	}*/
}
