package com.travelagency.tirana.service.Impl.DestinationImpl;

import com.travelagency.tirana.model.Destination;
import com.travelagency.tirana.service.Impl.DestinationImpl.SaveDestinationRequest;

import java.util.List;
import java.util.Optional;

public interface DestinationService {
    long save(SaveDestinationRequest request);
    List<Destination> getAll();
    Optional<Destination> getById(long id);
    void delete(long destinationId);
}
