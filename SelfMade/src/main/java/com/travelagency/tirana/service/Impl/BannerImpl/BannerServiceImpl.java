package com.travelagency.tirana.service.Impl.BannerImpl;

import com.travelagency.tirana.model.Banner;
import com.travelagency.tirana.model.Destination;
import com.travelagency.tirana.repository.BannerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BannerServiceImpl implements BannerService{

    private BannerRepository bannerRepository;

    public BannerServiceImpl(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public long save(SaveBannerRequest request) {
        var dbBanner = bannerRepository.findById(request.getId());
        if(dbBanner.isPresent()) {
            dbBanner.get().setName(request.getName());
            dbBanner.get().setPhoto(request.getPhoto());
            bannerRepository.save(dbBanner.get());
            return dbBanner.get().getId();
        }

        var newBanner = new Banner();
        newBanner.setName(request.getName());
        newBanner.setPhoto(request.getPhoto());
        bannerRepository.save(newBanner);
        return newBanner.getId();
    }

    @Override
    public List<Banner> getAll() {
        return bannerRepository.findAll();
    }

    @Override
    public Optional<Banner> getById(long id) {
        return bannerRepository.findById(id);
    }

    @Override
    public void delete(long bannerId) {
        var dbBanner = bannerRepository.findById(bannerId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        bannerRepository.delete(dbBanner);
    }
}
