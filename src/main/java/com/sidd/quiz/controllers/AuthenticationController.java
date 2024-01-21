package com.sidd.quiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidd.quiz.RequestBody.RefreshTokenRequest;
import com.sidd.quiz.RequestBody.SignInRequest;
import com.sidd.quiz.RequestBody.SignUpRequest;
import com.sidd.quiz.model.User;
import com.sidd.quiz.responseBody.JwtAuthResponse;
import com.sidd.quiz.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	@Autowired
private AuthenticationService authService ;

@PostMapping("/signUp")
public ResponseEntity<User>signUp(@RequestBody SignUpRequest signUpRequest  ){
	return ResponseEntity.ok(authService.signUp(signUpRequest) );
}

@PostMapping("/signIn")
public  ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignInRequest signInRequest ) {
    return ResponseEntity.ok(authService.signIn(signInRequest));
}

@PostMapping("/refreshToken")
public  ResponseEntity<JwtAuthResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest ) {
    return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
}

}
