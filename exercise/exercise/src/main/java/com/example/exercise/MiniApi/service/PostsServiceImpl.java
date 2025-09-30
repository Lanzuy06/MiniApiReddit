package com.example.exercise.MiniApi.service;

import com.example.exercise.MiniApi.dto.Comments;
import com.example.exercise.MiniApi.dto.Posts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PostsServiceImpl implements PostsService {

    private final Map<Long, Posts> posts = new HashMap<>();
    private final AtomicLong postIdCounter = new AtomicLong();
    private final AtomicLong commentIdCounter = new AtomicLong();

    @Override
    public Posts createPost(Posts post) {
        long id = postIdCounter.incrementAndGet();
        post.setPostId(id);
        posts.put(id, post);
        return post;
    }

    @Override
    public List<Posts> showAllPosts() {
        System.out.println(posts);
        return new ArrayList<>(posts.values());
    }

    @Override
    public Posts updatePosts(Long postId, String title, String updatedPosts) {
        Posts post = posts.get(postId);
        System.out.println(posts);
        if (post != null) {
            post.setTitle(title);
            post.setPost(updatedPosts);
        }
        return post;
    }

    @Override
    public boolean deletePosts(Long PostId) {
        return posts.remove(PostId) != null;
    }

    @Override
    public Comments addComment(Long postsId, Comments comment) {
        Posts post = posts.get(postsId);
        System.out.println(post);
        if (post != null) {
            long commentId = commentIdCounter.incrementAndGet();
            comment.setCommentId(commentId);
            post.getComments().add(comment);
            return comment;
        }
        return null;
    }

    @Override
    public Comments updateComment(Long postsId, Long commentsId, String updatedComment) {
        Posts post = posts.get(postsId);
        System.out.println(posts);
        if (post != null) {
            for (Comments c : post.getComments()) {
                if (c.getCommentId().equals(commentsId)) {
                    c.setComment(updatedComment);
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteComment(Long postsId, Long commentsId) {
        Posts post = posts.get(postsId);
        if (post != null) {
            return post.getComments().removeIf(comment -> comment.getCommentId().equals(commentsId));
        }
        return false;
    }
}
