package com.travelagency.tirana.service.Impl.InstagramImpl;

import com.travelagency.tirana.model.Instagram;
import com.travelagency.tirana.repository.InstagramRepository;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstagramServiceImpl implements InstagramService {

    private InstagramRepository instagramRepository;

    public InstagramServiceImpl(InstagramRepository instagramRepository) {
        this.instagramRepository = instagramRepository;
    }

    @Override
    public long save(SaveInstagramRequest request) {
        var dbBanner = instagramRepository.findById(request.getId());
        if(dbBanner.isPresent()) {
            dbBanner.get().setName(request.getName());
            dbBanner.get().setPhoto(request.getPhoto());
            instagramRepository.save(dbBanner.get());
            return dbBanner.get().getId();
        }

        var newBanner = new Instagram();
        newBanner.setName(request.getName());
        newBanner.setPhoto(request.getPhoto());
        instagramRepository.save(newBanner);
        return newBanner.getId();
    }

    @Override
    public List<Instagram> getAll() {
        return instagramRepository.findAll();
    }

    @Override
    public Optional<Instagram> getById(long id) {
        return instagramRepository.findById(id);
    }

    @Override
    public void delete(long bannerId) {
        var dbBanner = instagramRepository.findById(bannerId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        instagramRepository.delete(dbBanner);
    }
}
