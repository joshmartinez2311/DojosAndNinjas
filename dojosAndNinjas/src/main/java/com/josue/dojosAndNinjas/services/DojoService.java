package com.josue.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.josue.dojosAndNinjas.models.Dojo;
import com.josue.dojosAndNinjas.repository.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}

	//returns a list of all dojos
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	// creates a dojo object in the data base
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}

	// retrieves/finds dojo by id
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}

	// update dojo using id
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	// delete dojo by id
	public void deleteDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			dojoRepo.deleteById(id);
		}
	}

}
