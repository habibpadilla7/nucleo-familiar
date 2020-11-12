package com.habibpadilla.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idPersona;
	@Column(name="nombre", length = 50)
	private String nombre;
	@Column(name="apellido", length = 50)
	private String apellido;
	@Column(name="correo", length = 100)
	private String correo;
	
	public String toString()
	{
		String mensaje ="{Id:"+idPersona+", Nombre:"+nombre+", Apellido:"+apellido+", Correo:"+correo+"},"; 
		return mensaje;
	}
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
