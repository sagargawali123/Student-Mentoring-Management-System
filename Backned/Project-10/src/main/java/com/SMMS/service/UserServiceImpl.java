package com.SMMS.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SMMS.customexception.ResourceNotFoundException;
import com.SMMS.entities.Admin;
import com.SMMS.entities.Mentor;
import com.SMMS.entities.Role;
import com.SMMS.entities.Student;
import com.SMMS.entities.User;
import com.SMMS.repository.AdminRepository;
import com.SMMS.repository.MentorRepository;
import com.SMMS.repository.StudentRepository;
import com.SMMS.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Override
	public Object registerUser(User user) {
		// 
		User users=new User();
		users.setUserFirstName(user.getUserFirstName());
		users.setUserLastName(user.getUserLastName());
		users.setUserEmail(user.getUserEmail());
		users.setUserPassword(user.getUserPassword());
		users.setUserMoNo(user.getUserMoNo());
		users.setRegDate(user.getRegDate());
		users.setUserRole(user.getUserRole());
		
		User persistedUser=userRepository.save(users);
		
		return persistedUser;
	}



	@Override
	public Object authenticateUser(User user) {
		
		//get user's fields from the user object
		String role = user.getUserRole();
	//	Role role=user.getUserRole();
		String email = user.getUserEmail();
		String password = user.getUserPassword();
		
		//checking the role of user(admin)
		if(role.equals("admin")) {
			
			//if role is admin : save it in the asmin object
			Admin admin = adminRepository.findByEmailAndPassword(email, password);
			
			//check if admin exists
			if(admin != null)
				return admin;
			else
				
				//if admin does not exists : throw exception
				throw new ResourceNotFoundException("Wrong Credentials for Admin!");
		}
		
		//checking the role of user (student)
		if(role.equals("student")) {
			
			//if the role is student : save it in student object
			Student student = studentRepository.findByEmailAndPassword(email, password);
			
			//check if student exists
			if(student != null)
				return student;
			else
				
				//if student does not exists : throw exception
				throw new ResourceNotFoundException("Wrong Credentials for Student!");
		}
		
		//checking the role of user (mentor)
		if(role.equals("mentor")) {
			
			//if the role is mentor : save it in the mentor object
			Mentor mentor = mentorRepository.findByEmailAndPassword(email, password);
			
			//check if mentor exists
			if(mentor != null)
				return mentor;
			else
				
				//if mentor does not exists : throw exception
				throw new ResourceNotFoundException("Wrong Credentials for Mentor!");
		}
		else
			
			//if user does not exists : throw exception
			throw new ResourceNotFoundException("User does not exists!");
	}

}
