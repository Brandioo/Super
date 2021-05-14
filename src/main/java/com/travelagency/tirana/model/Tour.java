package com.travelagency.tirana.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tour")
@NoArgsConstructor
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Date createdAt;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "destinationId", insertable = false, updatable = false)
    private Destination destination;
    private long destinationId;

}

