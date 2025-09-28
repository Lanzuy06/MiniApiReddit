package com.example.exercise.MiniApi.dto;

import lombok.Data;

import java.util.LinkedHashMap;

@Data
public class Posts {

    private Long Id;
    private String Post;
    private LinkedHashMap<Long, Comments> comment = new LinkedHashMap<>();

}
