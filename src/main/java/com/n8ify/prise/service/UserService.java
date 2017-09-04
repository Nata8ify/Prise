package com.n8ify.prise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n8ify.prise.entity.User;
import com.n8ify.prise.entity.form.UserForm;
import com.n8ify.prise.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(UserForm userForm){
		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setTel(userForm.getTel());
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		userRepository.save(user);
	}
	
	public User getUser(String username, String password){
		return userRepository.findByUsernameAndPassword(username, password);
	}
}
