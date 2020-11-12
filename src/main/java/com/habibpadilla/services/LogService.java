package com.habibpadilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.habibpadilla.model.Log;
import com.habibpadilla.repo.ILogRepo;

@Service
public class LogService {
	
	@Autowired
	private ILogRepo lrepo;
	
	public List<Log> listLog(){
		return lrepo.findAll();
	}
	
	public Optional<Log> findByIdLog(Integer id){
		return lrepo.findById(id);
	}
	
	@Async
	public Log createLog(Log log) {
		return lrepo.save(log);
	}
	
	public Log updateLog(Log log) {
		return lrepo.save(log);
	}

	public boolean deleteLog(Integer id) {
		try {
			lrepo.deleteById(id);
			return true;
		}catch(Exception err){
			System.out.println(err);
			return false;
		}
	}
	
	

}
