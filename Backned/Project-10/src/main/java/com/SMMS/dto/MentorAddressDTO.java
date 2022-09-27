package com.SMMS.dto;

import com.SMMS.entities.Address;
import com.SMMS.entities.Mentor;

public class MentorAddressDTO {
	private Mentor mentor;
	private Address address;
	
	public MentorAddressDTO() {
	System.out.println("In MentorAddress' DTO constructor!");
}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
