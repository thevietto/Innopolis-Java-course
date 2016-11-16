package inno.repository.impl;

import inno.model.Post;
import inno.repository.AbstractDAO;
import inno.repository.PostRepository;
import org.springframework.stereotype.Repository;


@Repository
public class JdbsTemplatePostRepository extends AbstractDAO<Post> implements PostRepository {

    public JdbsTemplatePostRepository() {
        super("post", "post_seq", (resultSet, i) -> {
            Post post = new Post();
            post.setId(resultSet.getLong("id"));
            post.setTitle(resultSet.getString("title"));
            post.setText(resultSet.getString("text"));
            post.setDate(resultSet.getDate("creationDate"));
            return post;
        });
    }

    @Override
    public boolean add(Post post) {
        return add("title, text, creationDate", post.getTitle(), post.getText(), post.getDate());
    }
}
