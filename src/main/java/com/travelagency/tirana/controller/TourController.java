package com.travelagency.tirana.controller;


import com.travelagency.tirana.model.Tour;
import com.travelagency.tirana.service.Impl.TourImpl.SaveTourRequest;
import com.travelagency.tirana.service.Impl.TourImpl.TourService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tours")
public class TourController {

    private TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping
    public long save(@RequestBody SaveTourRequest request) {
        return tourService.save(request);
    }

    @GetMapping
    public List<Tour> getAll() {
        return tourService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable long id) {
        var result =  tourService.getById(id);
        if(result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable long id) {
        tourService.delete(id);
    }
}
