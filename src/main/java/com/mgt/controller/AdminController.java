package com.mgt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mgt.model.Admin;
import com.mgt.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService adminService;

	//Login Process
	 @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
	        String username = credentials.get("username");
	        String password = credentials.get("password");
	        
	        if (adminService.authenticate(username, password)) {
	            return ResponseEntity.ok(Map.of("message", "Login successful"));
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
	        }
	    }

	// Create User
	@PostMapping("/register")
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}

	// Update User
	@PutMapping("/update/{id}")
	public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
		return adminService.updateAdmin(id, admin);
	}

	// Delete User
	@DeleteMapping("/delete/{id}")
	public String deleteAdmin(@PathVariable Long id) {
		adminService.deleteAdmin(id);
		return "User deleted successfully!";
	}

	// View All Users
	@GetMapping("/users")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmin();
	}
}
