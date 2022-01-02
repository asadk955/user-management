package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ResourceNotFoundException;
import com.app.model.User;
import com.app.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*") 
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//get all users
	
	// so crt list 4 stored
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	//crt user rest api
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	//get user by id
	@GetMapping("/users/{id}")
	public ResponseEntity<User>  getUserById(@PathVariable Long id) throws ResourceNotFoundException {
		
		User user=userRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("User not exist with id:"+id));
		return ResponseEntity.ok(user);
	}
	
	//updte user api
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User userDetails) throws ResourceNotFoundException{
		
		User user=userRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("User not exist with id:"+id));
		
			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setDob(userDetails.getDob());
			user.setCity(userDetails.getCity());
			user.setPhone(userDetails.getPhone());
		
		User updateUser=	userRepository.save(user);
		
		return ResponseEntity.ok(updateUser);
		
	}
	
	//delete user api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) throws ResourceNotFoundException{
		
		User user=userRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("User not exist with id:"+id));
	
		userRepository.delete(user);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
	
	
	
	
	
	

}
