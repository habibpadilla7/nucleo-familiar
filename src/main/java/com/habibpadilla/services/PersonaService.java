package com.habibpadilla.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habibpadilla.model.Log;
import com.habibpadilla.model.Person;
import com.habibpadilla.repo.IPersonaRepo;


@Service
public class PersonaService {
	
	@Autowired
	private IPersonaRepo repo;

	@Autowired
	private LogService logService;
	
	public List<Person> listPerson(){
		List<Person> lperson=null;
		Log log=new Log();
		log.setPath("/personas");
		log.setEntered("");
		log.setMethod("GET");
		try {
			lperson=repo.findAll();
			log.setStatus("200");
			String response="";
			for(Person s : lperson) {
				response=response+s.toString();
			}
			log.setResponse(response);

			logService.createLog(log);
		}catch(Exception err){
			log.setResponse(""+err);
			logService.createLog(log);
		}
		return lperson;
	}
	
	public Optional<Person> findByIdPerson(Integer id){
		Optional<Person> lperson=null;
		Log log=new Log();
		log.setPath("/personas/"+id);
		log.setEntered("id:"+id);
		log.setMethod("GET");
		try {
			lperson=repo.findById(id);
			log.setStatus("200");
			String response=lperson.get().toString();
			log.setResponse(response);
			logService.createLog(log);
		}catch(Exception err){
			log.setResponse(""+err);
			logService.createLog(log);
		}
		return lperson;
	}
	
	public Person createPerson(Person per) {
		
		Person lperson=null;
		Log log=new Log();
		log.setPath("/personas");
		log.setMethod("POST");
		log.setEntered(""+per.toString());
		try {
			lperson=repo.save(per);;
			log.setStatus("200");
			log.setResponse(lperson.toString());

			logService.createLog(log);
		}catch(Exception err){
			log.setResponse(""+err);
			logService.createLog(log);
		}
		return lperson;
	}
	
	public Person updatePerson(Person per) {
		
		Person lperson=null;
		Log log=new Log();
		log.setPath("/personas");
		log.setMethod("PUT");
		log.setEntered(""+per.toString());
		try {
			lperson=repo.save(per);;
			log.setStatus("200");
			log.setResponse(lperson.toString());
			logService.createLog(log);
		}catch(Exception err){
			log.setResponse(""+err);
			logService.createLog(log);
		}
		return lperson;
	}

	public boolean deletePerson(Integer id) {
		Log log=new Log();
		log.setPath("/personas/"+id);
		log.setMethod("DELETE");
		log.setEntered("id:"+id);
		try {
			log.setStatus("200");
			log.setResponse("Se elimino el usuario con id "+id);
			logService.createLog(log);
			repo.deleteById(id);
			return true;
		}catch(Exception err){
			log.setStatus("");
			log.setResponse("No pudo eliminar el usuario con id "+id);
			logService.createLog(log);
			return false;
		}
	}

}
