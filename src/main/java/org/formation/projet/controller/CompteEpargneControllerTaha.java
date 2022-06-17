package org.formation.projet.controller;

import org.formation.projet.entity.ClientTaha;
import org.formation.projet.entity.CompteEpargneTaha;
import org.formation.projet.service.ClientServiceTaha;
import org.formation.projet.service.CompteEpargneServiceTaha;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/compteEpargne")
public class CompteEpargneControllerTaha {

	ClientServiceTaha clientService;
	CompteEpargneServiceTaha crService;

	public CompteEpargneControllerTaha(ClientServiceTaha clientService, CompteEpargneServiceTaha crService) {
		this.clientService = clientService;
		this.crService = crService;
	}

	@GetMapping("{id}")
	public String getcompteEpargne(@PathVariable(value = "id") Long id, Model model) {
		ClientTaha client = clientService.findClientById(id);
		CompteEpargneTaha compteEpargne = client.getCompteEpargne();

		model.addAttribute("compteEpargne", compteEpargne);

		return "compteEpargne";
	}

	@GetMapping("detail/{id}")
	public String getDetailcompteEpargne(@PathVariable(value = "id") Long id, Model model) {
		
		CompteEpargneTaha compteEpargne = crService.findById(id);
		System.out.println(compteEpargne);

		model.addAttribute("compteEpargne", compteEpargne);

		return "compteEpargne";
	}

	@GetMapping("/update/{id}")
	public String updatecompteEpargne(@PathVariable(value = "id") Long id, Model model) {

		CompteEpargneTaha compteEpargne = crService.findById(id);
		model.addAttribute("compteEpargne", compteEpargne);

		return "compteEpargneUpdate";
	}

	@PostMapping("/update/{id}")
	public String postcompteEpargne(@PathVariable(value = "id") Long id, CompteEpargneTaha cr) {
		cr.setId(id);
		crService.updateCompte(cr);

		return "redirect:/compteEpargne/detail/" + id;
	}

}
