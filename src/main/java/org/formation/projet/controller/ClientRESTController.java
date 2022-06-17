package org.formation.projet.controller;

import org.formation.projet.entity.Client;
import org.formation.projet.entity.Virement;
import org.formation.projet.service.ICrudServiceClient;
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
@RequestMapping("/clients")
public class ClientRESTController {

	@Autowired
	ICrudServiceClient IcrudClientServiceImpl;

	@PostMapping
	Client postClient(@RequestBody Client client) {
		IcrudClientServiceImpl.save(client);
		return client;
	}

	@GetMapping("/list")
	Iterable<Client> getClients() {
		IcrudClientServiceImpl.listClients();
		return (IcrudClientServiceImpl.listClients());
	}

	@DeleteMapping("{id}")
	void deleteClient(@PathVariable Long id) {
		IcrudClientServiceImpl.deleteById(id);
	}

	@PutMapping("{id}")
	ResponseEntity<Client> putClient(@PathVariable Long id, @RequestBody Client Client) {
		if (IcrudClientServiceImpl.checkClient(id)) {
			IcrudClientServiceImpl.editClient(id, Client);
			return new ResponseEntity<>(postClient(Client), HttpStatus.CREATED);
		}

		else {
			return new ResponseEntity<>(postClient(Client), HttpStatus.BAD_REQUEST);

		}

	}

	@PostMapping("/virement")
	void PostVirementClient(@RequestBody Virement virement) {
		IcrudClientServiceImpl.virement(virement);
	}
}
