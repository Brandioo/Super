package com.travelagency.tirana.service.Impl.ClientImpl;

import lombok.Data;

import java.util.Date;

@Data
public class SaveClientRequest {
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date createdAt;
}
