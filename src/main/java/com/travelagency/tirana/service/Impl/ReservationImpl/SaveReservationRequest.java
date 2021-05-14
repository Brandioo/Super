package com.travelagency.tirana.service.Impl.ReservationImpl;

import lombok.Data;

import java.util.Date;

@Data
public class SaveReservationRequest {
    private long id;
    private int finalPrice;
    private String comment;
    private Date checkInDate;
    private Date checkOutDate;
    private int tourId;
    private int clientId;
}
