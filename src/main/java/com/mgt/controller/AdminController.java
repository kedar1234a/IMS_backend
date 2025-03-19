package com.mgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
