package com.travelagency.tirana.service.Impl.ReservationImpl;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class SaveReservationRequest {
    private long id;
    private int tourId;
    private String name;
    private String email;
    private String phoneNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private int finalPrice;
    private String comment;

}
