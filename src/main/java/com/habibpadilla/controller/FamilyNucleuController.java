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

import com.habibpadilla.model.FamilyNucleu;
import com.habibpadilla.services.FamilyNucleuService;

@RestController
@RequestMapping("/nucleo-familiar")
public class FamilyNucleuController {

	@Autowired
	private FamilyNucleuService familyNucleuService;
	
	/** Metodo para llamar el listar familia */
	@GetMapping
	public List<FamilyNucleu> listFamilyNucleu(){
		return familyNucleuService.listFamilyNucleu();
	}
	
	/** Metodo para llamar el buscar Familia por su Id */
	@GetMapping(value="/{id}")
	public Optional<FamilyNucleu> findByIdFamilyNucleu(@PathVariable("id") Integer id){
		return familyNucleuService.findByIdFamilyNucleu(id);
	}
	
	/** Metodo para llamar el crear Familia */
	@PostMapping
	public FamilyNucleu createFamilyNucleu(@RequestBody FamilyNucleu familyNucleu) {
		return familyNucleuService.createFamilyNucleu(familyNucleu);
	}
	
	/** Metodo para llamar el actualizar familia */
	@PutMapping
	public FamilyNucleu updateLog(@RequestBody FamilyNucleu familyNucleu) {
		return familyNucleuService.updateFamilyNucleu(familyNucleu);
	}
	
	/** Metodo para llamar eliminar Familia */
	@DeleteMapping(value="/{id}")
	public String deleteLog(@PathVariable("id") Integer id) {
		boolean ok=familyNucleuService.deleteFamilyNucleu(id);
		if(ok) {
			return "Se elimino el log con id "+id;
		}else {
			return "No pudo eliminar el log con id "+id;
		}
			
	}
}