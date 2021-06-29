 package assignment.training.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="address123")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(length = 250)
	String addressLine;
	
	@Column(length = 250)
	String city;
	
	@Column(length = 100)
	String state;
	
	@Column(length = 6)
	Integer pincode;
	
	@ManyToOne
	private Person  person;

//	@ManyToOne(fetch = FetchType.LAZY,optional=false)
//	@JoinColumn(name="peron_id",nullable = false)
	
	
	public Address(String addressLine, String city, String state, Integer pincode) {
		
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	public Address() {
		
	}


	public String toString() {
		return "Address [addressLine=" + addressLine + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ "]";
	}
	
	
	

}
