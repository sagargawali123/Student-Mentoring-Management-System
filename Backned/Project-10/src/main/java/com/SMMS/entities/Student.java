package com.SMMS.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString.Exclude;



@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;

	@Column(name = "student_fname")
	private String studentFirstName;

	@Column(name="student_lname")
	private String studentLastName;

	@Column(name="student_email")
	private String studentEmail;

	@Column(name="student_password")
	private String studentPassword;

	@Column(name="student_mobile_no")
	private String studentMobileNo;

	@Column(name="student_dob")
	private LocalDate studentDob;

	@Enumerated(EnumType.STRING)
	private Gender studentGender;

	@Column(name="student_marks")
	private float studentMarks;

	@ManyToOne 
	@JoinColumn(name="student_course_id")
	@JsonIgnoreProperties("studentsList")
	@JsonIgnore 
	private Course assignedStudentCourse;

	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "student_address_id", referencedColumnName = "address_id", insertable = true, updatable = true)
	@JsonIgnore
	private Address studentAddress;

	@ManyToOne
	
	@JoinColumn(name="assigned_mentor_id", nullable = true)
	@JsonIgnoreProperties("studentsList")
	@JsonIgnore
	private Mentor assignedMentor;

	public Student() {
		System.out.println("In Student's para-less Constructor!");
	}

	public Student(Integer studentId, String studentFirstName, String studentLastName, String studentEmail,
			String studentPassword, String studentMobileNo, LocalDate studentDob, Gender studentGender,
			float studentMarks, Address studentAddress, Mentor assignedMentor ) {
		super();
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentEmail = studentEmail;
		this.studentPassword = studentPassword;
		this.studentMobileNo = studentMobileNo;
		this.studentDob = studentDob;
		this.studentGender = studentGender;
		this.studentMarks = studentMarks;
		this.studentAddress = studentAddress;
		this.assignedMentor=assignedMentor;

		System.out.println("In Student's parameterized Constructor!");
	}

	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + ", studentEmail=" + studentEmail + ", studentPassword=" + studentPassword
				+ ", studetMobileNo=" + studentMobileNo + ", studentDob=" + studentDob + ", studentGender="
				+ studentGender + ", studentMarks=" + studentMarks + "]";
	}
}
