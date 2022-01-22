package com.travelagency.tirana.controller;

import com.travelagency.tirana.model.Instagram;
import com.travelagency.tirana.service.Impl.InstagramImpl.InstagramService;
import com.travelagency.tirana.service.Impl.InstagramImpl.SaveInstagramRequest;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/instagrams")
public class InstagramController {

    private InstagramService instagramService;

    public InstagramController(InstagramService instagramService) {
        this.instagramService = instagramService;
    }

    @PostMapping
    public long save(@RequestBody SaveInstagramRequest request) {
        return instagramService.save(request);
    }

    @GetMapping
    public List<Instagram> getAll() {
        return instagramService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instagram> getInstagramById(@PathVariable long id) {
        var result =  instagramService.getById(id);
        if(result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteInstagram(@PathVariable long id) {
        instagramService.delete(id);
    }
}
