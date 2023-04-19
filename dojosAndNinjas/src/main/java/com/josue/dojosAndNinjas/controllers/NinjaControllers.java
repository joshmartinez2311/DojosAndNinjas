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
import org.springframework.web.bind.annotation.RequestMapping;

import com.josue.dojosAndNinjas.models.Dojo;
import com.josue.dojosAndNinjas.models.Ninja;
import com.josue.dojosAndNinjas.services.DojoService;
import com.josue.dojosAndNinjas.services.NinjaService;

@Controller
public class NinjaControllers {
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	
	//route to enroll a ninja
	@GetMapping("/ninja")
	public String enrollNinja(
			@ModelAttribute("ninja") Ninja ninja, Model model) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "EnrollNinja.jsp";
	}

//route that takes ninja info and redirects to home page
	@PostMapping("/ninja/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Ninja> ninjas = ninjaService.allNinjas();
			model.addAttribute("ninjas", ninjas);
			return "EnrollNinja.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	@RequestMapping("/ninja/delete/{dojoId}/{ninjaId}")
	public String deleteninja(@PathVariable("dojoId") Long dojoId, @PathVariable("ninjaId") Long ninjaId) {
		//finds dojo and ninjas
		Dojo dojo = dojoService.findDojo(dojoId);
		Ninja ninja = ninjaService.findNinja(ninjaId);
		
		//remove the ninja from the dojo object
		dojo.getNinjas().remove(ninja);
		
		//saves the new dojo object
		dojoService.updateDojo(dojo);
		
		//deletes ninja
		ninjaService.deleteNinja(ninjaId);
		
		return "redirect:/dojos/" + dojoId;
	}
}
	