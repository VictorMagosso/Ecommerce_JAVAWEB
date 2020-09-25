package br.com.cadastro.ecommerce.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.cadastro.ecommerce.model.Admin;

@Service
public interface AdminService{
	
	List<Admin> findAll();
	Admin findByEmail(String email);
	Admin save(Admin admin);
}
