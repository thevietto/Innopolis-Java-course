package inno.repository;

import inno.model.Comment;
import inno.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select c from Comment c where c.post = :post")
    List<Comment> findCommentsByPost(@Param("post") Post post);

    Post findПожалуйстаByTitleAndTextLike(String title, String text);

    List<Post> findByCommentsTextContains(String text);

}
