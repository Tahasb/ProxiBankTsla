package org.formation.projet.controller;

import org.formation.projet.entity.ClientTaha;
import org.formation.projet.entity.CompteCourantTaha;
import org.formation.projet.service.ClientServiceTaha;
import org.formation.projet.service.CompteCourantServiceTaha;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/compteCourant")
public class CompteCourantControllerTaha {

	ClientServiceTaha clientService;
	CompteCourantServiceTaha crService;

	public CompteCourantControllerTaha(ClientServiceTaha clientService, CompteCourantServiceTaha crService) {
		this.clientService = clientService;
		this.crService = crService;
	}

	@GetMapping("{id}")
	public String getCompteCourant(@PathVariable(value = "id") Long id, Model model) {
		ClientTaha client = clientService.findClientById(id);
		CompteCourantTaha compteCourant = client.getCompteCourant();

		model.addAttribute("compteCourant", compteCourant);

		return "compteCourant";
	}

	@GetMapping("detail/{id}")
	public String getDetailCompteCourant(@PathVariable(value = "id") Long id, Model model) {
		
		CompteCourantTaha compteCourant = crService.findById(id);
		System.out.println(compteCourant);

		model.addAttribute("compteCourant", compteCourant);

		return "compteCourant";
	}

	@GetMapping("/update/{id}")
	public String updateCompteCourant(@PathVariable(value = "id") Long id, Model model) {

		CompteCourantTaha compteCourant = crService.findById(id);
		model.addAttribute("compteCourant", compteCourant);

		return "compteCourantUpdate";
	}

	@PostMapping("/update/{id}")
	public String postCompteCourant(@PathVariable(value = "id") Long id, CompteCourantTaha cr) {
		cr.setId(id);
		crService.updateCompte(cr);

		return "redirect:/compteCourant/detail/" + id;
	}

}
