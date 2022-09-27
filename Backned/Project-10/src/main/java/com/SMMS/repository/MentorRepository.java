package com.SMMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SMMS.entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {

	//to find mentors by courseId
	@Query("select m from Mentor m join Course c on m.assignedMentorCourseId = c.courseId where c.courseId =:studentCourseId order by m.avgRating desc")
	public List<Mentor> findMentors(@Param("studentCourseId") int studentCourseId);

	//to find mentor by email & password (to authenticate mentor)
	@Query("select m from Mentor m where m.mentorEmail =:email and m.mentorPassword =:password")
	public Mentor findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	//to find mentor by email 
	@Query("select m from Mentor m where m.mentorEmail =:email")
	public List<Mentor> findByEmail(@Param("email") String mentorEmail);
}
