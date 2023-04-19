package com.josue.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.josue.dojosAndNinjas.models.Dojo;
import com.josue.dojosAndNinjas.models.Ninja;
import com.josue.dojosAndNinjas.repository.NinjaRepo;



@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	// returns a list of all ninjas
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}

	// creates a ninja in DataBase
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	// retrieve/find ninja by id
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else {
			return null;
		}
	}
	
	// update a ninja.
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	//delete a ninja using its id.
	public void deleteNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			ninjaRepo.deleteById(id);
		}
	}
		
	// will find ninjas that belong to a dojo
	public List<Ninja> findByDojo(Dojo dojo){
		return ninjaRepo.findAllNinjasByDojo(dojo);
	}
}
