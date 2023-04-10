/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Apr 8, 2023
 */
package dmacc.beans;

//import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vacations")
public class Vacations {
	@Id
	@GeneratedValue
	private long vacationId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resortId", referencedColumnName = "resortId")
	private Resort resort;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "activityId", referencedColumnName = "activityId")
	private Activities activity;
	

}
