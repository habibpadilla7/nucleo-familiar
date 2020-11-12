package com.habibpadilla.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habibpadilla.model.Family;
import com.habibpadilla.services.FamilyService;

@RestController
@RequestMapping("/familia")
public class FamilyController {
	@Autowired
	private FamilyService familyService;
	
	/** Metodo para llamar el listar familia */
	@GetMapping
	public List<Family> listFamily(){
		return familyService.listFamily();
	}
	
	/** Metodo para llamar el buscar Familia por su Id */
	@GetMapping(value="/{id}")
	public Optional<Family> findByIdFamily(@PathVariable("id") Integer id){
		return familyService.findByIdFamily(id);
	}
	
	/** Metodo para llamar el crear Familia */
	@PostMapping
	public Family createFamily(@RequestBody Family family) {
		return familyService.createFamily(family);
	}
	
	/** Metodo para llamar el actualizar familia */
	@PutMapping
	public Family updateLog(@RequestBody Family family) {
		return familyService.updateFamily(family);
	}
	
	/** Metodo para llamar eliminar Familia */
	@DeleteMapping(value="/{id}")
	public String deleteLog(@PathVariable("id") Integer id) {
		boolean ok=familyService.deleteFamily(id);
		if(ok) {
			return "Se elimino el log con id "+id;
		}else {
			return "No pudo eliminar el log con id "+id;
		}
			
	}

}
