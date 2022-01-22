package com.travelagency.tirana.service.Impl.InstagramImpl;
import com.travelagency.tirana.model.Instagram;

import java.util.List;
import java.util.Optional;

public interface InstagramService {
    long save(SaveInstagramRequest request);
    List<Instagram> getAll();
    Optional<Instagram> getById(long id);
    void delete(long clientId);
}
