package com.sidd.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sidd.quiz.Entity.Role;
import com.sidd.quiz.Repository.UserRepository;
import com.sidd.quiz.model.User;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class QuizApplication implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}
	
	public void run(String... args) {
		User adminAcc = userRepository.findByRole(Role.ADMIN);
		if(null == adminAcc) {
			User user = new User();
			user.setEmail("admin@gmail.com");
			user.setName("Admin");
			user.setRole(Role.ADMIN );
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
	

}
