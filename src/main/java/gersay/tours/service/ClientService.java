package gersay.tours.service;

import gersay.tours.entity.Client;
import gersay.tours.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public List<Client> getAllClients() {
        return repo.findAll();
    }

    public Client createClient(Client client) {
        return repo.save(client);
    }
}
