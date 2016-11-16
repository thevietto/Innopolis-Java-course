package inno.repository.impl;

import inno.model.Comment;
import inno.repository.AbstractDAO;
import inno.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl extends AbstractDAO<Comment> implements CommentRepository {

    public CommentRepositoryImpl() {
        super("comment", "comment_seq", (resultSet, i) -> {
            Comment comment = new Comment();
            comment.setId(resultSet.getLong("id"));
            comment.setText(resultSet.getString("text"));
            comment.setPostId(resultSet.getLong("post_id"));
            return comment;
        });
    }

    @Override
    public boolean add(Comment comment) {
        return add("text, post_id", comment.getText(), comment.getPostId());
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        return template.query("SELECT * FROM comment WHERE post_id = ?",
                new Object[]{postId}, rowMapper);
    }
}
