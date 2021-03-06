package com.anac.app.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anac.app.repository.UserRepository;



import com.anac.app.entity.User;
@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> list(){
		return userRepository.findAll();
	}
	
	public Optional<User> getOne(int id){
		return userRepository.findById(id);
	}
	
	public Optional<User> getByNombre(String nombre){
		return userRepository.findByNombre(nombre);
	}
	
	public void save(User user){
		userRepository.save(user);
	}
	
	public void delete(int id){
		userRepository.deleteById(id);
	}
	
	public boolean existsById(int id){
		return userRepository.existsById(id);
	}
	
	public boolean existsByNombre(String id){
		return userRepository.existsByNombre(id);
	}

}
