package com.sidd.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sidd.quiz.Repository.UserRepository;
import com.sidd.quiz.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService   {
	@Autowired
 private UserRepository userRepository;
 
 
 public UserDetailsService userDetailsService() {
	 return new UserDetailsService() {
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			return userRepository.findByemail(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found") ) ;
		}
	};
 }

}
