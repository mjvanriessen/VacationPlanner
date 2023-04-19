package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "resort")
public class Resort {
	//Private Variables
	@Id
	@GeneratedValue
	private long resortId;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private double cost;
	
	@OneToOne(mappedBy = "resort")
	private Vacations vacation;
}
