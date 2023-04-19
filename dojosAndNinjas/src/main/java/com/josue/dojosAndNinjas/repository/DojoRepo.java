package com.josue.dojosAndNinjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.josue.dojosAndNinjas.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{
	//finds all dojos in a list
	List<Dojo> findAll();
	
	//method to delete a dojo by id
	void deleteById(Long id);
}
