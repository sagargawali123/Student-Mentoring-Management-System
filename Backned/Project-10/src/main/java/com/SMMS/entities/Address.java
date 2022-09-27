package com.SMMS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", nullable = true)
	private Integer addressId;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;

	@Column
	private String area; 

	@Column
	private String city;

	@Column
	private String state;

	@Column
	private String country;

	@Column(name = "pin_code")
	private int pinCode;

	public Address() {
		System.out.println("In Address's para-less Constructor!");
	}

	public Address(String addressLine1, String addressLine2,
			String area, String city, String state, String country, int pinCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;

		System.out.println("In Address's parameterized Constructor!");
	}

		@Override
	public String toString() {
		return "Address [id=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", area=" + area + ", city="
				+ city + ", state=" + state + ", country=" + country + ", pinCode=" + pinCode + "]";
	}
}
