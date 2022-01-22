package com.travelagency.tirana.service.Impl.UserImpl;

import lombok.Data;

@Data
public class SaveUserRequest {
    private long id;
    private String email;
    private String password;
}
