package com.travelagency.tirana.service.Impl.BlogImpl;

import lombok.Data;

import java.util.Date;

@Data
public class SaveBlogRequest {

    private long id;
    private String title;
    private String author;
    private String content;
    private String photo;
    private Date createdAt;
}
