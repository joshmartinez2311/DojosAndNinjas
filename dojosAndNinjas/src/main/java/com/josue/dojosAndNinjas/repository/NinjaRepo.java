package com.josue.dojosAndNinjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.josue.dojosAndNinjas.models.Dojo;
import com.josue.dojosAndNinjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long>{
	//this method retrieves a list of ninjas.
	List<Ninja> findAll();
	
	//this method will allowed for a Ninja to be delete
	void deleteById(Long id);
	
	// this method will find all ninjas that belong to a  dojo
	List<Ninja> findAllNinjasByDojo(Dojo dojo);
}
