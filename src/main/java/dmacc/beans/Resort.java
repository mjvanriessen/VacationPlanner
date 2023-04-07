package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
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
	private String cost;
	
	
	
}
