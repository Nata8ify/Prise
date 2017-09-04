package com.n8ify.prise.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.n8ify.prise.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsernameAndPassword(String username, String password);
}
