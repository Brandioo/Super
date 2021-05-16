package com.travelagency.tirana.service.Impl.BannerImpl;

import lombok.Data;

@Data
public class SaveBannerRequest {
    private long id;
    private String name;
    private String photo;
}
