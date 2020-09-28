package br.com.cadastro.ecommerce.service.serviceImpl;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.cadastro.ecommerce.model.Admin;
import br.com.cadastro.ecommerce.model.repository.AdminRepository;

@Repository
@Transactional
public class AdminServiceImpl implements UserDetailsService{

	@Autowired
	private AdminRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = repository.findByEmail(email);
		
			if (admin == null) {
				throw new UsernameNotFoundException("Usuário não encontrado");
			}
			return new User(admin.getUsername(), admin.getPassword(), true, true, true, true, admin.getAuthorities());
		}
	}
	
