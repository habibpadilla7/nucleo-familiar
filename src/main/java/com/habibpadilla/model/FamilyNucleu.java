package com.habibpadilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "familynucleu")
public class FamilyNucleu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idPerson")
	Person person;
	
	@ManyToOne
	@JoinColumn(name="idFamily")
	Family family;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	
}