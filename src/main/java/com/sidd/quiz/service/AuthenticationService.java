package com.sidd.quiz.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sidd.quiz.Entity.Role;
import com.sidd.quiz.Repository.UserRepository;
import com.sidd.quiz.RequestBody.RefreshTokenRequest;
import com.sidd.quiz.RequestBody.SignInRequest;
import com.sidd.quiz.RequestBody.SignUpRequest;
import com.sidd.quiz.config.JwtAuthenticationFilter;
import com.sidd.quiz.model.User;
import com.sidd.quiz.responseBody.JwtAuthResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private jwtService jwtService;
	
	public User signUp(SignUpRequest signUpRequest ) {
		User user = new User();
		user.setEmail(signUpRequest.getEmail());
		user.setName(signUpRequest.getName() );
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()) );
		
		return userRepository.save(user);
	}
	
	
	
	public JwtAuthResponse signIn(SignInRequest signInRequests ) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequests.getEmail(), signInRequests.getPassword()  ) );
		
		UserDetails user = userRepository.findByemail(signInRequests.getEmail()).orElseThrow(()-> new IllegalArgumentException("Invalid Email or Passwrod"));
		var jwt = jwtService.generateToken(user);
		var reftoken = jwtService.generateRefereshtoken( new HashMap<>(), user);

		JwtAuthResponse jwtauthResponse = new JwtAuthResponse();
		jwtauthResponse.setToken(jwt);
		jwtauthResponse.setRefreshToken(reftoken); 
		
		return jwtauthResponse;
			
	}
	
	public JwtAuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
		UserDetails user = userRepository.findByemail(userEmail).get() ;
		if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
			var jwt = jwtService.generateToken(user);
			JwtAuthResponse jwtauthResponse = new JwtAuthResponse();
			jwtauthResponse.setToken(jwt);
			jwtauthResponse.setRefreshToken(refreshTokenRequest.getToken()); 
			
			return jwtauthResponse;
		}
		return null;
	}
	
}









