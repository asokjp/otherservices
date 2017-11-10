package com.wellpoint.microservices.services.service.gateway;


/**
 * 
 * Respective Claimant model at consumer side
 *
 */
//TODO - Claimant classes from both the consumer & producer can be moved to a common project
// and the changes to Claimant model would be owned by the producer
public class Claimant {
	
	/**
	 * 
	 */

	private String claimantId;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
	public String getClaimantId() {
		return claimantId;
	}

	public void setClaimantId(String claimantId) {
		this.claimantId = claimantId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Claimant()
	{
		firstName = null;
		lastName = null;
		claimantId = null;
		age = 0;
		email = null;
	}
	
	public Claimant(String firstName,String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("claimantId:" + claimantId);
		builder.append(" , firstName:" + firstName);
		builder.append(" , lastName:" + lastName);
		builder.append(" , email:" + email);
		builder.append(" , age:" + age);
		return builder.toString();
	}
}
