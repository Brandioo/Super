package com.travelagency.tirana.service.Impl.BannerImpl;

import com.travelagency.tirana.model.Banner;
import com.travelagency.tirana.model.Client;

import java.util.List;
import java.util.Optional;

public interface BannerService {
    long save(SaveBannerRequest request);
    List<Banner> getAll();
    Optional<Banner> getById(long id);
    void delete(long userId);
}
