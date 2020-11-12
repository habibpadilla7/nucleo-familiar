package com.habibpadilla.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habibpadilla.model.Person;
import com.habibpadilla.services.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	/** Metodo para llamar el listar la Persona */
	@GetMapping
	public List<Person> listPerson(){
		return personaService.listPerson();
	}
	
	/** Metodo para llamar el buscar una Persona por su Id */
	@GetMapping(value="/{id}")
	public Optional<Person> listPerson(@PathVariable("id") Integer id){
		return personaService.findByIdPerson(id);
	}
	
	/** Metodo para llamar la crear de la Persona */
	@PostMapping
	public Person createPerson(@RequestBody Person per) {
		return personaService.createPerson(per);
	}
	
	/** Metodo para llamar la actualizar de la Persona */
	@PutMapping
	public Person updatePerson(@RequestBody Person per) {
		return personaService.updatePerson(per);
	}
	
	/** Metodo para llamar la eliminar de la Person*/
	@DeleteMapping(value="/{id}")
	public String deletePerson(@PathVariable("id") Integer id) {
		boolean ok=personaService.deletePerson(id);
		if(ok) {
			return "Se elimino el usuario con id "+id;
		}else {
			return "No pudo eliminar el usuario con id "+id;
		}
			
	}


}
