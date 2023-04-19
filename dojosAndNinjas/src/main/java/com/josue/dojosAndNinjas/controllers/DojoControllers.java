package com.josue.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.josue.dojosAndNinjas.models.Dojo;
import com.josue.dojosAndNinjas.models.Ninja;
import com.josue.dojosAndNinjas.services.DojoService;
import com.josue.dojosAndNinjas.services.NinjaService;

@Controller
public class DojoControllers {
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;

	//root page of the app
	@GetMapping("/")
	public String Home() {
		return "redirect:/dojos/new";
	}

	// route that renders home page and new dojos once they are created
	@GetMapping("/dojos/new")
	public String allDojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "AddAndDisplayDojos.jsp";
	}

	//post request binds data from form;form and send it to the data basa
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "AddAndDisplayDojos.jsp";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	//route to display ninjas in a dojo
	@GetMapping("/dojos/{id}")
	public String dojosAndNinjas(@PathVariable("id")long id, Model model) {
		// gets dojo by id
		Dojo dojo = dojoService.findDojo(id);
		
		// gets list of ninjas that belong to a dojo
		List<Ninja> ninjas = ninjaService.findByDojo(dojo);
		
		//adds the dojo object to the model
		
		model.addAttribute("dojo", dojo);
		
		//adds the list of ninjas to the model
		model.addAttribute("ninjas", ninjas);
		return "dojoAndNinjas.jsp";
		
		
		
}
			
			

}