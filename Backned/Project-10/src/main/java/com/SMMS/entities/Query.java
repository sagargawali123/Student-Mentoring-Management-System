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
@Table(name = "queries")
public class Query {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer queryId;

	@Column 
	private String question;

	@Column(nullable = true)
	private String answer;

	public Query() {
		System.out.println("In Query's para-less Constructor!");
	}

	public Query(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;

		System.out.println("In Query's parameterized Constructor!");
	}

	
	@Override
	public String toString() {
		return "Query [id=" + queryId + ", question=" + question + ", answer=" + answer + "]";
	}
}
