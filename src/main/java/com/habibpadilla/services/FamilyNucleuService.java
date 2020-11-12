package com.habibpadilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habibpadilla.model.FamilyNucleu;
import com.habibpadilla.model.Log;
import com.habibpadilla.repo.IFamilyNucleuRepo;

@Service
public class FamilyNucleuService {

	@Autowired
	private IFamilyNucleuRepo repo;

	@Autowired
	private LogService logService;
	
	public List<FamilyNucleu> listFamilyNucleu(){
		List<FamilyNucleu> lfamily=null;
		Log log=new Log();
		log.setPath("/nucleo-familiar");
		log.setEntered("");
		log.setMethod("GET");
		try {
			lfamily=repo.findAll();
			log.setStatus("200");
			String response="";
			for(FamilyNucleu s : lfamily) {
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
	
	public Optional<FamilyNucleu> findByIdFamilyNucleu(Integer id){
		Optional<FamilyNucleu> lfamily=null;
		Log log=new Log();
		log.setPath("/nucleo-familiar/"+id);
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
	
	public FamilyNucleu createFamilyNucleu(FamilyNucleu family) {
		
		FamilyNucleu lfamily=null;
		Log log=new Log();
		log.setPath("/nucleo-familiar");
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
	
	public FamilyNucleu updateFamilyNucleu(FamilyNucleu family) {
		
		FamilyNucleu lfamily=null;
		Log log=new Log();
		log.setPath("/nucleo-familiar");
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

	public boolean deleteFamilyNucleu(Integer id) {
		Log log=new Log();
		log.setPath("/nucleo-familiar/"+id);
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