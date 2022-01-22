package com.travelagency.tirana.service.Impl.TourImpl;

import com.travelagency.tirana.model.TravelType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class SaveTourRequest {

    private long id;
    private String title;
    private int days;
    private int maxPeople;
    private int minPeople;
    private String description;
    private Date departure;
    private String photo;
    private boolean featured;
    @Enumerated(EnumType.STRING)
    private TravelType travelType;
    private int price;
    private int quantity;
    private int destinationId;

}
