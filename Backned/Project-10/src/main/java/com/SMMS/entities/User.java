package com.SMMS.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.ToString;

@Getter
@Setter
@Table(name = "user")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	
	@Column(name="user_fname")
	private String userFirstName;

	@Column(name="user_lname")
	private String userLastName;
  
	
	@Column(name="user_email")
	private String userEmail;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_mono")
	private String userMoNo;
	
	@Column(name="reg_date")
	private LocalDate regDate;
	
//	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
//	@JoinColumn(name = "user_address_id", referencedColumnName = "address_id", insertable = true, updatable = true)
//	@JsonIgnore 
//	private Address userAddress;




	
	@Column(name = "user_role")
	private String userRole;

	
	
   public User() {
	   System.out.println("In User's parameterless Constructor!");
   }
   
		
	
	
	public User(Integer userId,String userEmail, String userPassword, String userRole,LocalDate regdate,/* Address userAddress */String userFirstName,String userLastName,String userMoNo) {	super();		this.userEmail = userEmail;
	this.userPassword = userPassword;
	    this.userId=userId;
		this.userRole=userRole;
		this.regDate=regDate;
	//	this.userAddress=userAddress;
		this.userFirstName=userFirstName;
		this.userLastName=userLastName;
		this.userMoNo=userMoNo;
		
		System.out.println("In User's parameterized Constructor!");

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", regDate=" + regDate + ", userRole=" + userRole +", userFirstName=" + userFirstName +", userLastName=" + userLastName + "]";
	}
		
	
}
