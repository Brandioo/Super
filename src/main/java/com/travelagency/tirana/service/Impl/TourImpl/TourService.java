package com.travelagency.tirana.service.Impl.TourImpl;

import com.travelagency.tirana.model.Tour;
import com.travelagency.tirana.service.Impl.TourImpl.SaveTourRequest;

import java.util.List;
import java.util.Optional;

public interface TourService {
    long save(SaveTourRequest request);
    List<Tour> getAll();
    Optional<Tour> getById(long id);
    void delete(long tourId);
}
