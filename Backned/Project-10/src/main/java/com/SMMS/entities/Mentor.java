package com.SMMS.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "mentors")
public class Mentor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mentorId;

	@Column(name="mentor_fname")
	private String mentorFirstName;

	@Column(name="mentor_lname")
	private String mentorLastName;

	@Column(name="mentor_email")
	private String mentorEmail;

	@Column(name="mentor_password")
	private String mentorPassword;

	@Column(name="mentor_mono")
	private String mentorMoNo;

	@Column(name="batch_size")
	private int batchSize;

	@Column(name = "current_batch_size", columnDefinition = "integer default 00")
	private int currentBatchSize;

	@Column(name="mentor_dob")
	private LocalDate mentorDob;

	@Enumerated(EnumType.STRING)
	private Gender mentorGender;

	@Column(name="mentor_join_year")
	private LocalDate mentorJoinYear;

	@Column(name="avg_rating")
	private float avgRating;

	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "mentor_address_id", referencedColumnName = "address_id", insertable = true, updatable = true)
	//@JsonIgnore 
	private Address mentorAddress;

	@ManyToOne
	@JoinColumn(name="mentor_course_id")
	private Course assignedMentorCourseId;

	@OneToMany(mappedBy = "assignedMentor",cascade = CascadeType.ALL , orphanRemoval = true)
	@JsonIgnoreProperties("assignedMentor")
	@JsonIgnore
	private List<Student> studentsList = new ArrayList<>();

	public Mentor() {
		System.out.println("In Mentor's para-less Constructor!");
	}

	public Mentor(Integer mentorId, String mentorFirstName, String mentorLastName, String mentorEmail, String mentorPassword,
			String mentorMoNo, int batchSize, LocalDate mentorDob, Gender mentorGender, LocalDate mentorJoinYear,
			float avgRating) {
		super();
		this.mentorId = mentorId;
		this.mentorFirstName = mentorFirstName;
		this.mentorLastName = mentorLastName;
		this.mentorEmail = mentorEmail;
		this.mentorPassword = mentorPassword;
		this.mentorMoNo = mentorMoNo;
		this.batchSize = batchSize;
		this.mentorDob = mentorDob;
		this.mentorGender = mentorGender;
		this.mentorJoinYear = mentorJoinYear;
		this.avgRating = avgRating;

		System.out.println("In Mentor's parameterized Constructor!");
	}

		@Override
	public String toString() {
		return "Mentor [id=" + mentorId + ", mentorFirstName=" + mentorFirstName + ", mentorLastName=" + mentorLastName
				+ ", mentorEmail=" + mentorEmail + ", mentorPassword=" + mentorPassword + ", mentorMoNo=" + mentorMoNo
				+ ", batchSize=" + batchSize + ", mentorDob=" + mentorDob + ", mentorGender=" + mentorGender
				+ ", mentorJoinYear=" + mentorJoinYear + ", avgRating=" + avgRating + "]";
	}

	// Helper Functions

	//to add Student in mentor table
	public void addStudent(Student student) {
		studentsList.add(student);
		student.setAssignedMentor(null);
	}

	//to remove student from mentor table
	public void removeStudent(Student student) {
		studentsList.remove(student);
		student.setAssignedMentor(null);
	}
}
