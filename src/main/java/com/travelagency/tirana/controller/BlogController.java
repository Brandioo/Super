package com.travelagency.tirana.controller;

import com.travelagency.tirana.model.Blog;
import com.travelagency.tirana.service.Impl.BlogImpl.BlogService;
import com.travelagency.tirana.service.Impl.BlogImpl.SaveBlogRequest;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/blogs")
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public long save(@RequestBody SaveBlogRequest request) {
        return blogService.save(request);
    }

    @GetMapping
    public List<Blog> getAll() {
        return blogService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable long id) {
        var result =  blogService.getById(id);
        if(result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable long id) {
        blogService.delete(id);
    }
}
