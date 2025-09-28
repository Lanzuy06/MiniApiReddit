package com.example.exercise.MiniApi.controllers;

import com.example.exercise.MiniApi.dto.Comments;
import com.example.exercise.MiniApi.dto.Posts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Api")
public class ApiController {

    @RequestMapping("/showPosts/{Id}")
    public Posts showPosts(Long Id){
      return null;
    }
}
