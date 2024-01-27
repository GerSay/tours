package gersay.tours.controller;

import gersay.tours.entity.Contract;
import gersay.tours.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService service;

    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts() {
        List<Contract> contracts = service.getAllContracts();
        return ResponseEntity.ok(contracts);
    }

    @PostMapping
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        Contract createdContract = service.createContract(contract);
        return ResponseEntity.ok(createdContract);
    }
}
