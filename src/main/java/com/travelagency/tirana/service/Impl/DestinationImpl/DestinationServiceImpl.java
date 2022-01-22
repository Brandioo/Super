package com.travelagency.tirana.service.Impl.DestinationImpl;

import com.travelagency.tirana.model.Destination;
import com.travelagency.tirana.repository.DestinationRepository;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {

    private DestinationRepository destinationRepository;

    public DestinationServiceImpl(final DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public long save(SaveDestinationRequest request) {
        var dbDestination = destinationRepository.findById(request.getId());
        if(dbDestination.isPresent()) {
            dbDestination.get().setName(request.getName());
            dbDestination.get().setPhoto(request.getPhoto());
            destinationRepository.save(dbDestination.get());
            return dbDestination.get().getId();
        }

        var newDestination = new Destination();
        newDestination.setName(request.getName());
        newDestination.setPhoto(request.getPhoto());
        newDestination.setCreatedAt(new Date());
        destinationRepository.save(newDestination);
        return newDestination.getId();
    }

    @Override
    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }

    @Override
    public Optional<Destination> getById(long id) {
        return destinationRepository.findById(id);
    }

    @Override
    public void delete(long destinationId) {
        var dbDestination = destinationRepository.findById(destinationId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        destinationRepository.delete(dbDestination);
    }
}

