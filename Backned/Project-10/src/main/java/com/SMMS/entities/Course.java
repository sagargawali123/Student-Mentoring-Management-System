package com.SMMS.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;

	@Column(name="course_name" ,length = 20)
	private String courseName;

	@Column(name="start_date")
	private LocalDate startDate;

	@Column(name="end_date")
	private LocalDate endDate;


	@OneToMany(mappedBy = "assignedStudentCourse",cascade = CascadeType.ALL ,orphanRemoval = true)
@JsonIgnoreProperties("assignedStudentCourse")
	@JsonIgnore 
	private List<Student> studentsList = new ArrayList<>();

	@OneToMany(mappedBy = "assignedMentorCourseId",cascade = CascadeType.ALL ,orphanRemoval = true)
	@JsonIgnoreProperties("assignedMentorCourseId")
	@JsonIgnore
	private List<Mentor> mentorsList = new ArrayList<>();


	public Course() {
		System.out.println("In Course's para-less Constructor!");
	}	

	public Course(int courseId, String courseName, LocalDate startDate, LocalDate endDate, List<Student> studentsList,List<Mentor> mentorsList) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentsList = studentsList;
		this.mentorsList = mentorsList;

		System.out.println("In Course's parameterized Constructor!");
	}


		@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}


}
