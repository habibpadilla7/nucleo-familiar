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

import com.habibpadilla.model.Log;
import com.habibpadilla.services.LogService;

@RestController
@RequestMapping("/logs")
public class LogController {

	@Autowired
	private LogService logService;
	
	/** Metodo para llamar el listar del Log */
	@GetMapping
	public List<Log> listLog(){
		return logService.listLog();
	}
	
	/** Metodo para llamar el buscar un Log por su Id */
	@GetMapping(value="/{id}")
	public Optional<Log> findByIdLog(@PathVariable("id") Integer id){
		return logService.findByIdLog(id);
	}
	
	/** Metodo para llamar el crear del Log */
	@PostMapping
	public Log createLog(@RequestBody Log log) {
		return logService.createLog(log);
	}
	
	/** Metodo para llamar el actualizar del Log */
	@PutMapping
	public Log updateLog(@RequestBody Log log) {
		return logService.updateLog(log);
	}
	
	/** Metodo para llamar el eliminar Log */
	@DeleteMapping(value="/{id}")
	public String deleteLog(@PathVariable("id") Integer id) {
		boolean ok=logService.deleteLog(id);
		if(ok) {
			return "Se elimino el log con id "+id;
		}else {
			return "No pudo eliminar el log con id "+id;
		}
			
	}
}
