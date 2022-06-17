package org.formation.projet.service;

import java.util.Optional;

import org.formation.projet.entity.Client;
import org.formation.projet.entity.Virement;

public interface ICrudServiceClient {

	public void save(Client client);

	public Iterable<Client> listClients();

	public void deleteById(Long id);

	public boolean checkClient(Long id);

	public void editClient(long id, Client Client);

	public Optional<Client> getClientbyId(Long id);

	public void virement(Virement virement);


}
