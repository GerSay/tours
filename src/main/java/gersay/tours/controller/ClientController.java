package gersay.tours.controller;

import gersay.tours.entity.Client;
import gersay.tours.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = service.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = service.createClient(client);
        return ResponseEntity.ok(createdClient);
    }
}
