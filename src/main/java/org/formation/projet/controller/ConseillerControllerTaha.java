package org.formation.projet.controller;

import org.formation.projet.entity.ConseillerTaha;
import org.formation.projet.entity.Virement;
import org.formation.projet.service.ClientServiceTaha;
import org.formation.projet.service.ConseillerServiceTaha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conseillers")
public class ConseillerControllerTaha {

	@Autowired
	ConseillerServiceTaha conseillerService;

	@PostMapping
	public ConseillerTaha postConseiller(@RequestBody ConseillerTaha conseiller) {
		conseillerService.save(conseiller);
		return conseiller;
	}

	@GetMapping("/list")
	public Iterable<ConseillerTaha> getConseillers() {
		conseillerService.listConseillers();
		return (conseillerService.listConseillers());
	}

	@DeleteMapping("{id}")
	public void deleteConseiller(@PathVariable Long id) {
		conseillerService.deleteById(id);
	}

	
//	@PutMapping("{id}")
//	ResponseEntity<Conseiller> putConseiller(@PathVariable Long id, @RequestBody Conseiller conseiller) {
//		if (conseillerService.checkConseiller(id)) {
//			conseillerService.editConseiller(id, conseiller);
//		}
//
//		else {
//			return new ResponseEntity<>(postConseiller(conseiller), HttpStatus.BAD_REQUEST);
//
//		}
//	}
}

//@Controller
////@RequestMapping("/client")
//public class ConseillerController {
//	@Autowired
//	ConseillerService clientService;
//	Conseiller conseiller = new Conseiller("Taha", "SBAITI");
//	
//	
//
//	@GetMapping("/index.html")
//	public String showPage() {
//		clientService.save(conseiller);
//		return "index";

//	@PostMapping("/client")
//	public void postCoffee() {
//
//		Client1 client1 = new Client1("Taha", "Sbaiti");
////		client1.setNom("toto");
////		client1.setPrenom("tata");
//		clientRepository.save(client1);
//	}
