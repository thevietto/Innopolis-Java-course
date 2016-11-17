package inno.repository;

import inno.model.Comment;

import java.util.List;

public interface CommentRepository {

    List<Comment> findAll();

    Comment find(Long id);

    boolean add(Comment comment);

    boolean remove(Long id);

    List<Comment> findByPostId(Long postId);
    
}
