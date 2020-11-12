package com.habibpadilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.habibpadilla.model.Log;
import com.habibpadilla.model.Family;
import com.habibpadilla.repo.IFamilyRepo;

public class FamilyService {

	@Autowired
	private IFamilyRepo repo;

	@Autowired
	private LogService logService;
	
	public List<Family> listFamily(){
		List<Family> lfamily=null;
		Log log=new Log();
		log.setPath("/familia");
		log.setEntered("");
		log.setMethod("GET");
		try {
			lfamily=repo.findAll();
			log.setStatus("200");
			String response="";
			for(Family s : lfamily) {
				response=response+s.toString();
			}
			log.setResponse(response);

			logService.createLog(log);
		}catch(Exception err){
			log.setResponse(""+err);
			logService.createLog(log);
		}
		return lfamily;
	}
	
	public Optional<Family> findByIdFamily(Integer id){
		Optional<Family> lfamily=null;
		Log log=new Log();
		log.setPath("/familia/"+id);
		log.setEntered("id:"+id);
		log.setMethod("GET");
		try {
			lfamily=repo.findById(id);
			log.setStatus("200");
			String response=lfamily.get().toString();
			log.setResponse(response);
			logService.createLog(log);
		}catch(Exception err){
			log.setResponse(""+err);
			logService.createLog(log);
		}
		return lfamily;
	}
	
	public Family createFamily(Family family) {
		
		Family lfamily=null;
		Log log=new Log();
		log.setPath("/familia");
		log.setMethod("POST");
		log.setEntered(""+family.toString());
		try {
			lfamily=repo.save(family);;
			log.setStatus("200");
			log.setResponse(lfamily.toString());

			logService.createLog(log);
		}catch(Exception err){
			log.setResponse(""+err);
			logService.createLog(log);
		}
		return lfamily;
	}
	
	public Family updateFamily(Family family) {
		
		Family lfamily=null;
		Log log=new Log();
		log.setPath("/familia");
		log.setMethod("PUT");
		log.setEntered(""+family.toString());
		try {
			lfamily=repo.save(family);;
			log.setStatus("200");
			log.setResponse(lfamily.toString());
			logService.createLog(log);
		}catch(Exception err){
			log.setResponse(""+err);
			logService.createLog(log);
		}
		return lfamily;
	}

	public boolean deleteFamily(Integer id) {
		Log log=new Log();
		log.setPath("/Familia/"+id);
		log.setMethod("DELETE");
		log.setEntered("id:"+id);
		try {
			log.setStatus("200");
			log.setResponse("Se elimino la familia con id "+id);
			logService.createLog(log);
			repo.deleteById(id);
			return true;
		}catch(Exception err){
			log.setStatus("");
			log.setResponse("No pudo eliminar la familia con id "+id);
			logService.createLog(log);
			return false;
		}
	}
}
