package inno.config;

import inno.model.Post;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import java.util.List;

public class TestClass {


    @PreAuthorize("#postAuthor == principal.username")
    public void deletePost(String postAuthor) {
        // не может удалить чужой пост
    }

    @PostAuthorize("returnObject.age < principal.age")
    public Post getPost() {
        return new Post();
    }

    @PreFilter(filterTarget = "someList", value = "filterObject == principal.username")
    public void preFilter(List<String> someList) {

    }

    @PostFilter("filterObject.age < principal.age")
    public List<Post> getPosts() {
        return null;
    }
}
