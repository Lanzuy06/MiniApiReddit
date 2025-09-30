package com.example.exercise.MiniApi.controllers;

import com.example.exercise.MiniApi.dto.Comments;
import com.example.exercise.MiniApi.dto.Posts;
import com.example.exercise.MiniApi.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class ApiController {

    @Autowired
    private PostsService postsService;

    @GetMapping
    public List<Posts> showAllPosts(){

      return postsService.showAllPosts();

    }

    @PostMapping("/{id}")
    public ResponseEntity<Posts> createPost(@RequestBody Posts post){

        return ResponseEntity.ok(postsService.createPost(post));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Posts> updatePost(@PathVariable Long id, @RequestBody Posts updatedPost) {

        Posts post = postsService.updatePosts(id, updatedPost.getTitle(), updatedPost.getPost());
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {

        return postsService.deletePosts(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Comments> addComment(@PathVariable Long postId, @RequestBody Comments comment) {

        Comments comments = postsService.addComment(postId, comment);
        System.out.println(comments);
        return comments != null ? ResponseEntity.ok(comments) : ResponseEntity.notFound().build();

    }

    @PutMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comments> updateComment(@PathVariable Long postId, @PathVariable Long commentId,
                                                 @RequestBody Comments updatedComment) {

        Comments c = postsService.updateComment(postId, commentId, updatedComment.getComment());
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {

        return postsService.deleteComment(postId, commentId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }


}
