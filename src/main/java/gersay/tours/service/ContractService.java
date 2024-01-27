package gersay.tours.service;

import gersay.tours.entity.Contract;
import gersay.tours.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepository repo;

    public List<Contract> getAllContracts() {
        return repo.findAll();
    }

    public Contract createContract(Contract contract) {
        return repo.save(contract);
    }
}
