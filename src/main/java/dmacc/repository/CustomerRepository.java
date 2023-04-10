/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Apr 5, 2023
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
