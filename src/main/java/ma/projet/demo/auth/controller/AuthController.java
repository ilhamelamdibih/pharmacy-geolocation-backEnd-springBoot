package ma.projet.demo.auth.controller;

import ma.projet.demo.auth.request.AuthenticationRequest;
import ma.projet.demo.auth.service.AuthService;
import ma.projet.demo.auth.service.AuthServiceImpl;
import ma.projet.demo.config.JwtUtils;
import ma.projet.demo.userSecurity.dao.JpaUserDetailsService;

import ma.projet.demo.userSecurity.model.UserSecurity;
import ma.projet.demo.users.Requests.UsersRequest;
import ma.projet.demo.users.model.Users;
import ma.projet.demo.users.repository.UsersRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:3000")
public class AuthController {

	@Autowired
    private  AuthenticationManager authenticationManager;
	@Autowired
    private  JpaUserDetailsService jpaUserDetailsService ;
	@Autowired
    private  AuthService authService;
	@Autowired
    private  UsersRepository usersRepository;
	@Autowired
    private  JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request, HttpServletResponse response) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword(),
                            new ArrayList<>()));
            final UserDetails user = jpaUserDetailsService.loadUserByUsername(request.getEmail());
            if (user != null) {
                String jwt = jwtUtils.generateToken(user);
                Cookie cookie = new Cookie("jwt", jwt);
                cookie.setMaxAge(7000 * 24 * 60 * 60); 
//                cookie.setSecure(true);
                cookie.setHttpOnly(true);
                cookie.setPath("/"); // Global
                response.addCookie(cookie);
                return ResponseEntity.ok(jwt);
            }
            return ResponseEntity.status(400).body("Error authenticating");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body("" + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserSecurity> register(@RequestBody UsersRequest user) throws Exception {
        return ResponseEntity.ok(authService.AddUser(user).map(UserSecurity::new).orElseThrow(() -> new Exception("Unknown")));
    }
    @PostMapping("/user")
    public ResponseEntity<Map<String, Object>> getUserFromBody(@RequestBody Map<String, String> requestBody) {
        try {
            String jwt = requestBody.get("jwt");
            if (jwt == null) {
                return ResponseEntity.status(400).body(null);
            }
            String email = jwtUtils.extractUsername(jwt);
            final Users user = usersRepository.findByEmail(email).orElseThrow(() -> new Exception("User not found"));

            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("id", user.getId());
            userDetails.put("first_name", user.getFirst_name());
            userDetails.put("last_name", user.getLast_name());
            userDetails.put("email", user.getEmail());
            userDetails.put("roles", user.getRoles());

            return ResponseEntity.ok(userDetails);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body(null);
        }
    }
}
