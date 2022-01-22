package com.travelagency.tirana.service.Impl.BlogImpl;

import com.travelagency.tirana.model.Blog;
import com.travelagency.tirana.model.Destination;
import com.travelagency.tirana.repository.BlogRepository;
import com.travelagency.tirana.service.Impl.BlogImpl.SaveBlogRequest;
import com.travelagency.tirana.service.Impl.BlogImpl.BlogService;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public long save(SaveBlogRequest request) {
        var dbBlog = blogRepository.findById(request.getId());
        if(dbBlog.isPresent()) {
            dbBlog.get().setTitle(request.getTitle());
            dbBlog.get().setAuthor(request.getAuthor());
            dbBlog.get().setContent(request.getContent());
            dbBlog.get().setPhoto(request.getPhoto());
            blogRepository.save(dbBlog.get());
            return dbBlog.get().getId();
        }

        var newBlog = new Blog();
        newBlog.setTitle(request.getTitle());
        newBlog.setAuthor(request.getAuthor());
        newBlog.setContent(request.getContent());
        newBlog.setPhoto(request.getPhoto());
        blogRepository.save(newBlog);
        return newBlog.getId();
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> getById(long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(long blogId) {
        var dbBlog = blogRepository.findById(blogId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        blogRepository.delete(dbBlog);
    }
}
