package com.travelagency.tirana.controller;

import com.travelagency.tirana.model.Client;
import com.travelagency.tirana.service.ClientService;
import com.travelagency.tirana.service.Impl.ClientImpl.SaveClientRequest;
import com.travelagency.tirana.service.Impl.DestinationImpl.SaveDestinationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping
    public long save(@RequestBody SaveClientRequest request) {
        return clientService.save(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id) {
        var result =  clientService.getById(id);
        if(result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.delete(id);
    }
}
