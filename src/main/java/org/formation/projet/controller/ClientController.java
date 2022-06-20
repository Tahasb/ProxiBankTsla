package org.formation.projet.controller;

import org.formation.projet.entity.Client;
import org.formation.projet.service.ICrudServiceClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientController {

	ICrudServiceClient iCrudServiceClient;

	public ClientController(ICrudServiceClient iCrudServiceClient) {

		this.iCrudServiceClient = iCrudServiceClient;
	}

	// La page localhost:8080/client tombe ici
	@GetMapping
	public String getAllClients(Model model) {
		Iterable<Client> clients = iCrudServiceClient.listClients();
		model.addAttribute("clients", clients);

		// Cette ligne me redirige vers la page indexClient.html
		return "indexClient";
	}

	@GetMapping("/formClient")
	public String getFormClientView(Model model) {

		Client client = new Client();
		model.addAttribute("client", client);

		// Cette ligne me redirige vers la page addClient.html
		return "addClient";
	}

	@PostMapping("/addClient")
	public String addClient(Client client) {
		iCrudServiceClient.save(client);

		return "redirect:/client";
	}

	@GetMapping("/update/{id}")
	public String GetUpdateClient(@PathVariable(value = "id") Long id, Model model) {
		Boolean existe = iCrudServiceClient.checkClient(id);

		if (existe = true) {
			Client client = iCrudServiceClient.getClientbyId(id).get();

			model.addAttribute("client", client);

			return "updateClient";
		}
//        Ajouter une exception et une vue spécialement dédiée en cas d'erreur
		return "updateClient";
	}

	@PostMapping("/update/{id}")
	public String PostUpdateClient(@PathVariable(value = "id") Long id, Client client) {
		client.setId(id);
		iCrudServiceClient.save(client);
		return "redirect:/client";
	}

	@GetMapping("/deleteClient/{id}")
	public String deleteunClient(@PathVariable(value = "id") Long id) {
		iCrudServiceClient.deleteById(id);
		System.out.println("azerzerarze " + id);
		return "redirect:/client";
 
	}

//	@PostMapping("/virement")
//	public String PostVirementClient(@PathVariable(value = "montant") double montant,
//			@PathVariable(value = "compte_debiteur") String numeroCompteDebit,
//			@PathVariable(value = "compte_crediteur") String numeroCompteCredit) {
//
//		iCrudServiceClient.virement(montant, numeroCompteDebit, numeroCompteCredit);
//		return "redirect:/client";
//	}

}
