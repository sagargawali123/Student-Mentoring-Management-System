package com.SMMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SMMS.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	// to get Address Details from studentId
	@Query("select a from Address a join Student s on s.studentAddress = a.addressId where s.studentId=:studentId ")
	Address findAddressByStudentId(@Param("studentId") int  studentId);

	// to get Address Details from MentorId
	@Query("select a from Address a join Mentor m on m.mentorAddress = a.addressId where m.mentorId=:mentorId ")
	Address findAddressByMentorId(@Param("mentorId") int  mentorId);
}
