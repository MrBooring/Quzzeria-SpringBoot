package com.sidd.quiz.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.sidd.quiz.Entity.Role;
import com.sidd.quiz.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
Optional<UserDetails> findByemail(String email);
	
 User findByRole(Role role);

}
