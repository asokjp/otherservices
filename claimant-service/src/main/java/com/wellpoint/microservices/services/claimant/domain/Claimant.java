package com.wellpoint.microservices.services.claimant.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "claimant")
public class Claimant {
	
	/**
	 * Claimant Model 
	 */
//TODO need to incorporate lombok library
	@Id
	private String claimantId;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public Claimant()
	{
		
	}
	
	public Claimant(String firstName,String lastName,String claimantId, String email, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.claimantId = claimantId;
		this.email = email;
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
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getClaimantId() {
		return claimantId;
	}

	public void setClaimantId(String claimantId) {
		this.claimantId = claimantId;
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
