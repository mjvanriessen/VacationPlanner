/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Apr 5, 2023
 */
package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer  {
	@Id
	@GeneratedValue
	private long customerId;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zip;
	
	@OneToOne(mappedBy = "customer")
	private Vacations vacation;
}
