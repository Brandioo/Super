package com.travelagency.tirana.service.Impl.TourImpl;

import com.travelagency.tirana.model.Tour;
import com.travelagency.tirana.repository.TourRepository;
import com.travelagency.tirana.service.TourService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TourServiceImpl implements TourService {
    private TourRepository tourRepository;

    public TourServiceImpl(final TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public long save(SaveTourRequest request) {
        var dbTour = tourRepository.findById(request.getId());
        if (dbTour.isPresent()) {
            dbTour.get().setTitle(request.getTitle());
            dbTour.get().setDays(request.getDays());
            dbTour.get().setMaxPeople(request.getMaxPeople());
            dbTour.get().setMinPeople(request.getMinPeople());
            dbTour.get().setDescription(request.getDescription());
            dbTour.get().setDeparture(request.getDeparture());
            dbTour.get().setPhoto(request.getPhoto());
            dbTour.get().setFeatured(request.isFeatured());
            dbTour.get().setTravelType(request.getTravelType());
            dbTour.get().setPrice(request.getPrice());
            dbTour.get().setQuantity(request.getQuantity());
            dbTour.get().setDestinationId(request.getDestinationId());
            tourRepository.save(dbTour.get());
            return dbTour.get().getId();
        }
        var newTour = new Tour();
        newTour.setTitle(request.getTitle());
        newTour.setDays(request.getDays());
        newTour.setMaxPeople(request.getMaxPeople());
        newTour.setMinPeople(request.getMinPeople());
        newTour.setDescription(request.getDescription());
        newTour.setDeparture(request.getDeparture());
        newTour.setPhoto(request.getPhoto());
        newTour.setFeatured(request.isFeatured());
        newTour.setTravelType(request.getTravelType());
        newTour.setPrice(request.getPrice());
        newTour.setQuantity(request.getQuantity());
        newTour.setCreatedAt(new Date());
        newTour.setDestinationId(request.getDestinationId());
        tourRepository.save(newTour);
        return newTour.getId();
    }


    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }

    @Override
    public Optional<Tour> getById(long id) {
        return tourRepository.findById(id);
    }

    @Override
    public void delete(long tourId) {
        var dbTour = tourRepository.findById(tourId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        tourRepository.delete(dbTour);
    }
}
