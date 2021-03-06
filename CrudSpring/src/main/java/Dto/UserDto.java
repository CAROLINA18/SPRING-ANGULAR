package Dto;

import java.util.Date;

public class UserDto {
	
	private String nombre;
	private Integer id;
	private String surname;
	private String password;
	private Date fecha_creacion;
	private String celular;
	private String email;
	
	public UserDto() {
		super();
	}

	public UserDto(Integer id,String nombre, String surname, String password, Date fecha_creacion, String celular, String email) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.surname = surname;
		this.password = password;
		this.fecha_creacion = fecha_creacion;
		this.celular = celular;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDto [nombre=" + nombre + ", id=" + id + ", surname=" + surname + ", password=" + password
				+ ", fecha_creacion=" + fecha_creacion + ", celular=" + celular + "]";
	}
		

}
