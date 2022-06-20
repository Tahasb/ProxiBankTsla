package org.formation.projet.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.formation.projet.DTO.ConseillerDTO;
import org.formation.projet.entity.Conseiller;
import org.formation.projet.service.ICrudServiceConseiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conseiller")
public class ConseillerController {

	@Autowired
	ICrudServiceConseiller iCrudServiceConseiller;

//	public ConseillerController(ICrudServiceConseiller iCrudServiceConseiller) {
//
//		this.iCrudServiceConseiller = iCrudServiceConseiller;
//	}

	// La page localhost:8080/Conseiller tombe ici
	@GetMapping
	public String getAllconseillers(Model model) {
		Iterable<Conseiller> conseillers = iCrudServiceConseiller.listConseillers();
		model.addAttribute("conseillers", conseillers);

		// Cette ligne me redirige vers la page indexConseiller.html
		return "Directeur-Dashboard";
	}

	@GetMapping("/formConseiller")
	public String getFormConseillerView(Model model) {

		ConseillerDTO conseillerDto = new ConseillerDTO();
//		Conseiller conseiller = new Conseiller();
		model.addAttribute("conseillerDto", conseillerDto);

		// Cette ligne me redirige vers la page addConseiller.html
		return "DirecteurAjouterUnConseiller";
	}

	@PostMapping("/addConseiller")
	public String addConseiller(ConseillerDTO conseillerDto) throws ParseException {
		Conseiller conseiller = new Conseiller();
		conseiller.setNom(conseillerDto.getNom());
		conseiller.setPrenom(conseillerDto.getPrenom());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(conseillerDto.getDate());
		
		conseiller.setDate(date);
		iCrudServiceConseiller.save(conseiller);
		return "redirect:/conseiller";
	}

	@GetMapping("/update/{id}")
	public String GetUpdateConseiller(@PathVariable(value = "id") Long id, Model model) {
		Boolean existe = iCrudServiceConseiller.checkConseiller(id);

		if (existe = true) {
			Conseiller conseiller = iCrudServiceConseiller.getConseillerbyId(id).get();

			ConseillerDTO conseillerDto = new ConseillerDTO();
			conseillerDto.setId(conseiller.getId());
			conseillerDto.setNom(conseiller.getNom());
			conseillerDto.setPrenom(conseiller.getPrenom());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(conseiller.getDate());
			conseillerDto.setDate(strDate);
			
			model.addAttribute("conseillerDto", conseillerDto);

			return "updateConseiller";
		}
//        Ajouter une exception et une vue spécialement dédiée en cas d'erreur
		return "updateConseiller";
	}

	@PostMapping("/update/{id}")
	public String postUpdateConseiller(@PathVariable(value = "id") Long id, ConseillerDTO conseillerDto) throws ParseException {
	
		Conseiller conseiller = new Conseiller();
		
		conseiller.setNom(conseillerDto.getNom());
		conseiller.setPrenom(conseillerDto.getPrenom());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(conseillerDto.getDate());
		
		conseiller.setDate(date);
		conseiller.setId(id);
		
		iCrudServiceConseiller.save(conseiller);
		return "redirect:/conseiller";
	}

	@PostMapping("/deleteConseiller/{id}")
	public String deleteConseiller(@PathVariable(value = "id") Long id) {
		iCrudServiceConseiller.deleteById(id);
		return "redirect:/conseiller";
	}

}
