package inno.repository.impl;

import inno.model.Comment;
import inno.model.Post;
import inno.repository.PostRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Post> findAll() {
        TypedQuery<Post> query = em.createQuery("SELECT post FROM Post post", Post.class);
        return query.getResultList();
    }


    @Override
    public Post find(Long id) {
        Post post = em.find(Post.class, id);
        post.getComments().size();
        return post;
    }

    @Override
    public boolean add(Post post) {
        em.persist(post);
        return true;
    }

    @Override
    public void update(Post post) {
        em.merge(post);
    }

    @Override
    public boolean remove(Long id) {
        em.remove(em.find(Post.class, id));
        return true;
    }

    @Override
    public List<Post> findByText(String text) {
        TypedQuery<Post> query = em.createQuery(
                "SELECT post from Post post WHERE post.text LIKE :text", Post.class);
        query.setParameter("text", text);
        return query.getResultList();
    }
}


















