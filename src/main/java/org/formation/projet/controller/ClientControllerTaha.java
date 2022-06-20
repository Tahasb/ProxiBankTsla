package org.formation.projet.controller;

import java.text.ParseException;
import java.util.List;

import org.formation.projet.DTO.ClientDTOTaha;
import org.formation.projet.entity.ClientTaha;
import org.formation.projet.entity.Credit;
import org.formation.projet.entity.Virement;
import org.formation.projet.service.ClientServiceTaha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientControllerTaha {

	@Autowired
	ClientServiceTaha clientService;
	
	
	public double mensualite;

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
		return "Conseiller-virement";
	}



	@PostMapping("/virement")
	public String postVirement(Virement virement, Model model) throws ParseException {
		clientService.virement(virement);
		System.err.println(virement);
		return "redirect:/client";

	}

	@GetMapping("/Conseiller-simulation-credit")
	public String GetSimulationCredit(Model model) {
		Credit credit = new Credit();
		model.addAttribute(credit);
		return "Conseiller-simulation-credit";
	}

	@PostMapping("/credit")
	public String PostSimulationCredit(Credit credit) {
		System.err.println(credit);
		mensualite = clientService.calculerMensualiterCredit(credit);
		return "redirect:/client/credit";
	}

	@GetMapping("/credit")
	public String GetSimulationCreditResultat(Model model) {
		model.addAttribute("mensualite", String.format("%.2f", mensualite));
		return "Conseiller-simulation-credit-Affichage";
	}

	// @PathVariable(
	// value = "compte_debiteur") String numeroCompteDebit,
//			@PathVariable(value = "compte_crediteur") String numeroCompteCredit, 
//			@PathVariable(value = "montant") Long montant) {

//			String username = request.getParameter("username");
//		Virement virement = new Virement(numeroCompteDebit, numeroCompteCredit, montant);
//		clientService.virement(virement); 
//		
//		System.err.println(virement);
//		return "redirect:/client";

}
//	public String PostVirementClient(@PathVariable(value = "montant") double montant,
//			@PathVariable(value = "compte_debiteur") String numeroCompteDebit,
//			@PathVariable(value = "compte_crediteur") String numeroCompteCredit) {
//		System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		
//		Virement virement = new Virement();
//		
//		
//		clientService.virement(virement);
//		return "redirect:/client";
//	}
