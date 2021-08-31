package com.anac.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anac.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User , Integer>{
	Optional<User> findByNombre (String name);
	boolean existsByNombre(String name);

	

}
