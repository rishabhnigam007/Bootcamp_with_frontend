package com.icf.bootcamp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author 55683
 *
 */

@Entity
@Table(name = "Dependent", indexes = @Index(name = "dependents_index", columnList = "dependentID"))
public class Dependants extends ErrorResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dependentID;

	@NotNull(message = "First Name can't null")
	@NotEmpty(message = "First Name can't empty")
	private String firstName;
	@NotNull(message = "Last Name can't null")
	@NotEmpty(message = "Last Name can't empty")
	private String lastName;
	@NotNull(message = "Gender can't null")
	@NotEmpty(message = "Gender can't empty")
	private String gender;
	@Temporal(value = TemporalType.DATE)
	@NotNull(message = "DOB can't null")
	private Date dob;
	@NotNull(message = "Relationship can't null")
	@NotEmpty(message = "Relationship can't empty")
	private String relationship;

	/**
	 * This is a default constructor with no argument
	 */
	
	public Dependants() {
	}
	
	/**
	 * 
	 * @param dependentID - Integer
	 * @param firstName - String
	 * @param lastName - String
	 * @param gender - String
	 * @param dob - Date
	 * @param relationship - String
	 */

	public Dependants(int dependentID, @NotNull(message = "First Name can't null") String firstName,
			@NotNull(message = "Last Name can't null") String lastName,
			@NotNull(message = "Gender can't null") String gender, @NotNull(message = "DOB can't null") Date dob,
			@NotNull(message = "Relationship can't null") String relationship) {
		super();
		this.dependentID = dependentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.relationship = relationship;
	}

	public int getDependentID() {
		return dependentID;
	}

	public void setDependentID(int dependentID) {
		this.dependentID = dependentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Override
	public String toString() {
		return "Dependants [dependentID=" + dependentID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", dob=" + dob + ", relationship=" + relationship + "]";
	}

}