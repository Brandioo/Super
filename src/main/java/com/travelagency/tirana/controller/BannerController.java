package com.travelagency.tirana.controller;

import com.travelagency.tirana.model.Banner;
import com.travelagency.tirana.service.Impl.BannerImpl.BannerService;
import com.travelagency.tirana.service.Impl.BannerImpl.SaveBannerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/banners")
public class BannerController {
    private BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @PostMapping
    public long save(@RequestBody SaveBannerRequest request) {
        return bannerService.save(request);
    }

    @GetMapping
    public List<Banner> getAll() {
        return bannerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banner> getBannerById(@PathVariable long id) {
        var result =  bannerService.getById(id);
        if(result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteBanner(@PathVariable long id) {
        bannerService.delete(id);
    }
}
