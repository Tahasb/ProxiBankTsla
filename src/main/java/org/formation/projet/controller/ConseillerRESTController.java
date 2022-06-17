package org.formation.projet.controller;

import org.formation.projet.entity.Conseiller;
import org.formation.projet.service.CrudConseillerServiceImpl;
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
@RequestMapping("/conseiller1")
public class ConseillerRESTController {

	@Autowired
	CrudConseillerServiceImpl crudConseillerServiceImpl;

	@PostMapping
	Conseiller postUnConseiller(@RequestBody Conseiller conseiller) {
		crudConseillerServiceImpl.save(conseiller);
		return conseiller;
	}

	@GetMapping("/list")
	Iterable<Conseiller> getDesConseillers() {
		crudConseillerServiceImpl.listConseillers();
		return (crudConseillerServiceImpl.listConseillers());
	}

	@DeleteMapping("{id}")
	void deleteUnConseiller(@PathVariable Long id) {
		crudConseillerServiceImpl.deleteById(id);
	}

	@PutMapping("{id}")
	ResponseEntity<Conseiller> putUnConseiller(@PathVariable Long id, @RequestBody Conseiller conseiller) {
		if (crudConseillerServiceImpl.checkConseiller(id)) {
			crudConseillerServiceImpl.editConseiller(id, conseiller);
			return new ResponseEntity<>(postUnConseiller(conseiller), HttpStatus.CREATED);
		}

		else {
			return new ResponseEntity<>(postUnConseiller(conseiller), HttpStatus.BAD_REQUEST);

		}
	}
}

//@Controller
////@RequestMapping("/client")
//public class ConseillerRESTController {
//	@Autowired
//	CrudConseillerServiceImpl clientService;
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
