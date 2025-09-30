package com.example.exercise.MiniApi.service;

import com.example.exercise.MiniApi.dto.Comments;
import com.example.exercise.MiniApi.dto.Posts;

import java.util.List;

public interface PostsService {

    public Posts createPost(Posts post);

    public List<Posts> showAllPosts();

    public Posts updatePosts(Long postId,String Title, String updatedPosts);

    public boolean deletePosts(Long postId);

    public Comments addComment(Long postsId, Comments comment);

    public Comments updateComment(Long postsId, Long commentsId, String updatedComment);

    public boolean deleteComment(Long postsId, Long commentsId);

}
