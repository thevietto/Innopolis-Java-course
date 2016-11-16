package inno.repository.impl;

import inno.model.Post;
import inno.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimplePostRepository implements PostRepository {

    private List<Post> posts = new ArrayList<>();

    {
        posts.add(new Post("Новость 1", "text 1"));
        posts.add(new Post("Новость 2", "text 2"));
        posts.add(new Post("Новость 3", "text 3"));
        posts.add(new Post("Новость 4", "text 4"));
        posts.add(new Post("Новость 5", "text 5"));
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post find(Long id) {
        return posts.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public boolean add(Post post) {
        return posts.add(post);
    }

    @Override
    public boolean remove(Long id) {
        return posts.removeIf(p -> Objects.equals(p.getId(), id));
    }
}
