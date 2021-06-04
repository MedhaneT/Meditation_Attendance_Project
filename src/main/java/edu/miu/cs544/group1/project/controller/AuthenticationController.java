package edu.miu.cs544.group1.project.controller;

import edu.miu.cs544.group1.project.config.JPAUserDetails;
import edu.miu.cs544.group1.project.config.JPAUserDetailsService;
import edu.miu.cs544.group1.project.controller.dto.JwtTokenDto;
import edu.miu.cs544.group1.project.controller.dto.LoginRequestDto;
import edu.miu.cs544.group1.project.controller.dto.RegisterUserDto;
import edu.miu.cs544.group1.project.controller.dto.UserDataDto;
import edu.miu.cs544.group1.project.domain.User;
import edu.miu.cs544.group1.project.security.JwtUtil;
import edu.miu.cs544.group1.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JPAUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<JwtTokenDto> register(@RequestBody RegisterUserDto registerUserDto) {
        User savedUser = userService.registerUser(registerUserDto);
        JPAUserDetails userDetails = new JPAUserDetails(savedUser);
        UserDataDto userData = new UserDataDto(userDetails);
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtTokenDto(token, userData));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new RuntimeException(ex));
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        UserDataDto userData = new UserDataDto((JPAUserDetails) userDetails);
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtTokenDto(token, userData));
    }
}
