package tn.edu.esprit.eskimooc.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee implements Serializable {

	
	private int id;
	private Integer cin;
	private String firstname;
	private String lastname;
	private String telephone;
	private String address;
	private Date hiring_date;
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	public int getId() {
		return this.id;
	}

	
	public void setId(int id) {
		this.id = id;
	}   
	public Integer getCin() {
		return this.cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}   
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public Date getHiring_date() {
		return this.hiring_date;
	}

	public void setHiring_date(Date hiring_date) {
		this.hiring_date = hiring_date;
	}
   
}
