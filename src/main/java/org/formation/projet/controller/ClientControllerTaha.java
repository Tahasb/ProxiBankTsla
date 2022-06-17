package org.formation.projet.controller;

import java.text.ParseException;
import java.util.List;

import org.formation.projet.DTO.ClientDTOTaha;
import org.formation.projet.entity.ClientTaha;
import org.formation.projet.service.ClientServiceTaha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientControllerTaha {

	@Autowired
	ClientServiceTaha clientService;

//	public ClientControllerTaha(ClientServiceTaha clientService) {
//
//		this.clientService = clientService;
//	}

	// La page localhost:8080/client tombe ici
	@GetMapping
	public String getAllClients(Model model) {
		List<ClientTaha> clients = clientService.findAll();
		System.out.println(clients);
		model.addAttribute("clients", clients);

		// Cette ligne me redirige vers la page indexClient.html
		return "Conseiller-Dashboard";
	}

	@GetMapping("/formClient")
	public String getFormClientView(Model model) {

		ClientDTOTaha clientDto = new ClientDTOTaha();
		model.addAttribute("client", clientDto);

		// Cette ligne me redirige vers la page addClient.html
		return "ConseillerAjouterUnclient";
	}

	@PostMapping("/addClient")
	public String addClient(ClientDTOTaha clientDto, Model model) throws ParseException {

		ClientTaha client = clientService.convertClientDToToClient(clientDto);

		clientService.addClient(client);
		return "redirect:/client";

	}

	@GetMapping("/update/{id}")
	public String GetUpdateClient(@PathVariable(value = "id") Long id, Model model) {
		ClientTaha client = clientService.findClientById(id);
		ClientDTOTaha clientDto = clientService.convertClientToClientDto(client);
		model.addAttribute("clientDto", clientDto);
		return "updateClient";
	}

	@PostMapping("/update/{id}")
	public String postUpdateClient(@PathVariable(value = "id") Long id, ClientDTOTaha clientDto) throws ParseException {
		
		ClientTaha client = clientService.convertClientDToToClient(clientDto);
		client.setId(id);
		clientService.addClient(client);
		return "redirect:/client";
	}

	@PostMapping("/deleteClient/{id}")
	public String deleteClient(@PathVariable(value = "id") Long id) {
		clientService.deleteClientById(id);
		return "redirect:/client";
	}
	@GetMapping("/Conseiller-faire-un-virement")
	public String GetVirementClient() {
		return "Conseiller-faire-un-virement";
	}
	@GetMapping("/Conseiller-simulation-credit")
	public String GetSimulationCredit() {
		return "Conseiller-simulation-credit";
	}
	

}
