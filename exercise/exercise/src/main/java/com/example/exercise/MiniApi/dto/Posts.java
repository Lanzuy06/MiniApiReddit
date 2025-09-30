package com.example.exercise.MiniApi.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Posts {

    private Long PostId;
    private String Title;
    private String Post;
    private List<Comments> comments = new ArrayList<>();

}
