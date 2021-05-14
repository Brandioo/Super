package com.travelagency.tirana.service;

import com.travelagency.tirana.model.Client;
import com.travelagency.tirana.service.Impl.ClientImpl.SaveClientRequest;
import com.travelagency.tirana.service.Impl.DestinationImpl.SaveDestinationRequest;


import java.util.List;
import java.util.Optional;

public interface ClientService {
    long save(SaveClientRequest request);
    List<Client> getAll();
    Optional<Client> getById(long id);
    void delete(long clientId);
}
