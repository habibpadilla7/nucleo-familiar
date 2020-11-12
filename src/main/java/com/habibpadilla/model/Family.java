package com.habibpadilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "family")
public class Family {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	
	@Column(name="nombre", length = 50)
	private String nombre;

	@Column(name="apellido", length = 50)
	private String apellido;
	
	@Column(name="correo", length = 50)
	private String correo;
	
	@Column(name="tipopersona", length = 50)
	private String tipopersona;
	
	public String toString()
	{
		String mensaje ="{Id:"+id+", Nombre:"+nombre+", Apellido:"+apellido+", Correo:"+correo+"},"; 
		return mensaje;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTipopersona() {
		return tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

	
}