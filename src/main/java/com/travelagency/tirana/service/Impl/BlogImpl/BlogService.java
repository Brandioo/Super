package com.travelagency.tirana.service.Impl.BlogImpl;

import com.travelagency.tirana.model.Blog;
import com.travelagency.tirana.model.Client;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    long save(SaveBlogRequest request);
    List<Blog> getAll();
    Optional<Blog> getById(long id);
    void delete(long blodId);
}
