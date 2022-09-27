package com.SMMS.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;

	@Column
	private String adminEmail;

	@Column
	private String adminPassword;

	@Column
	private LocalDate adminDob;

	@Enumerated(EnumType.STRING)
	private Gender adminGender;
	
	public Admin() {
		System.out.println("In Admin's para-less Constructor!");
	}

	public Admin(String adminEmail, String adminPassword, LocalDate adminDob, Gender adminGender) {
		super();
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminDob = adminDob;
		this.adminGender = adminGender;
		
		System.out.println("In Admin's parameterized Constructor!");
	}

	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword
				+ ", adminDob=" + adminDob + ", adminGender=" + adminGender + "]";
	}

	
}
