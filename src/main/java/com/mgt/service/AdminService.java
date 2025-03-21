package com.mgt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgt.dao.AdminRepository;
import com.mgt.model.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	 public boolean authenticate(String username, String password) {
	        Optional<Admin> user = adminRepository.findByUsername(username);
	        return user.isPresent() && user.get().getPassword().equals(password);
	    }
	
	public Admin createAdmin(Admin user) {
		return adminRepository.save(user);
	}

	public Admin updateAdmin(Long id, Admin updatedAdmin) {
		Optional<Admin> existingUser = adminRepository.findById(id);
		if (existingUser.isPresent()) {
			Admin user = existingUser.get();
			user.setUsername(updatedAdmin.getUsername());
			user.setEmail(updatedAdmin.getEmail());
			user.setRole(updatedAdmin.getRole());
			return adminRepository.save(user);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void deleteAdmin(Long id) {
		adminRepository.deleteById(id);
	}

	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

}
