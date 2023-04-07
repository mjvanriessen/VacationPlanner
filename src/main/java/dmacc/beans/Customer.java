/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Apr 5, 2023
 */
package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long customerID;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zip;
}
