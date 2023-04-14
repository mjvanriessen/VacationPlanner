/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Apr 2, 2023
 */
package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "activities")
public class Activities {
	@Id
	@GeneratedValue
	private long activityId;
	private String name;
	private String type;
	private double cost;
	
	@OneToOne(mappedBy = "activity")
	private Vacations vacation;
}
