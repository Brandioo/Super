package com.travelagency.tirana.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "banner")
@Data
@NoArgsConstructor
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String photo;

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
