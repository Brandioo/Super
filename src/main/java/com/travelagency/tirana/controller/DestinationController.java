package com.travelagency.tirana.controller;


import com.travelagency.tirana.model.Destination;

import com.travelagency.tirana.service.Impl.DestinationImpl.DestinationService;
import com.travelagency.tirana.service.Impl.DestinationImpl.SaveDestinationRequest;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/destinations")
public class DestinationController {

    private DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping
    public long save(@RequestBody SaveDestinationRequest request) {
        return destinationService.save(request);
    }

    @GetMapping
    public List<Destination> getAll() {
        return destinationService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable long id) {
        var result =  destinationService.getById(id);
        if(result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable long id) {
        destinationService.delete(id);
    }
}
