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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table(name="address")
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
	
//	@ManyToOne(targetEntity =Person.class )
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@Cascade(value = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="person_id")
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
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Address() {
		
	}


	public String toString() {
		return "Address [addressLine=" + addressLine + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ "]";
	}
	
	
	

}
