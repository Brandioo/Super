package com.travelagency.tirana.service.Impl.ClientImpl;

import com.travelagency.tirana.model.Client;
import com.travelagency.tirana.repository.ClientRepository;
import com.travelagency.tirana.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public long save(SaveClientRequest request) {
        var dbClient = clientRepository.findById(request.getId());
        if (dbClient.isPresent()) {
            dbClient.get().setName(request.getName());
            dbClient.get().setEmail(request.getEmail());
            dbClient.get().setPhoneNumber(request.getPhoneNumber());
            dbClient.get().setCreatedAt(request.getCreatedAt());
            clientRepository.save(dbClient.get());

            return dbClient.get().getId();
        }

        var newClient = new Client();
        newClient.setName(request.getName());
        newClient.setEmail(request.getEmail());
        newClient.setPhoneNumber(request.getPhoneNumber());
        newClient.setCreatedAt(new Date());
        clientRepository.save(newClient);
        return newClient.getId();
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }


    @Override
    public Optional<Client> getById(long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void delete(long clientId) {
        var dbClient = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        clientRepository.delete(dbClient);
    }
}
