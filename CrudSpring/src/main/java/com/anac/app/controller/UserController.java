package com.anac.app.controller;

import org.apache.commons.lang3.StringUtils;
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

import java.util.Date;
import java.util.List;

import com.anac.app.entity.User;
import com.anac.app.services.UserService;

import Dto.Mensaje;
import Dto.UserDto;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/lists")
	public ResponseEntity<List<User>> list(){
		List<User> list = userService.list();
		return new ResponseEntity(list , HttpStatus.OK);	
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") int id){
		if(!userService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		User user = userService.getOne(id).get();
		return new ResponseEntity(user , HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombre}")
	public ResponseEntity<User> getByNombre(@PathVariable("nombre") String nombre){
		if(!userService.existsByNombre(nombre))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		User user = userService.getByNombre(nombre).get();
		return new ResponseEntity(user , HttpStatus.OK);
			
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody UserDto userDto){
		System.out.println(userDto);
		if(StringUtils.isBlank(userDto.getNombre()))
			return new ResponseEntity(new Mensaje("Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(userDto.getEmail()))
			return new ResponseEntity(new Mensaje("Email es obligatorio"), HttpStatus.BAD_REQUEST);
		if(userService.existsByNombre(userDto.getSurname()))
			return new ResponseEntity(new Mensaje("Nombre ya existe"), HttpStatus.BAD_REQUEST);
		
		User user = new User();
			user.setNombre(userDto.getNombre());
			user.setCelular(userDto.getCelular());
			user.setSurname(userDto.getSurname());
			user.setPassword(userDto.getPassword());
			user.setFecha_creacion(new Date());
			user.setEmail(userDto.getEmail());
		
		userService.save(user);
		return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UserDto userDto){
		if(!userService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		
		if(StringUtils.isBlank(userDto.getNombre()))
			return new ResponseEntity(new Mensaje("Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(userDto.getEmail()))
			return new ResponseEntity(new Mensaje("Email es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(userService.existsByNombre(userDto.getSurname()))
			return new ResponseEntity(new Mensaje("Nombre ya existe"), HttpStatus.BAD_REQUEST);
				
		User user =userService.getOne(id).get();
			user.setNombre(userDto.getNombre());
			user.setCelular(userDto.getCelular());
			user.setSurname(userDto.getSurname());
			user.setPassword(userDto.getPassword());
			user.setFecha_creacion(new Date());
			user.setEmail(userDto.getEmail());
		
		userService.save(user);
		return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!userService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        userService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
	

}
