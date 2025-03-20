package com.mgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String loginAdmin(@RequestBody Admin admin) {
	    Admin user = null;
	    
	    // Check if username is provided and try login with username
	    if (admin.getUsername() != null && !admin.getUsername().isEmpty()) {
	        user = adminService.loginAdminByUsername(admin.getUsername(), admin.getPassword());
	    }
	    // If username not provided or login failed, try with email
	    if (user == null && admin.getEmail() != null && !admin.getEmail().isEmpty()) {
	        user = adminService.loginAdminByEmail(admin.getEmail(), admin.getPassword());
	    }

	    if (user != null) {
	        return "Login Successfully";
	    } else {
	        return "Login Failed ... Please enter valid username/email and password";
	    }
	}

	// Create User
	@PostMapping("/create")
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
