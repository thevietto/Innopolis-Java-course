package inno.controller.api;

import inno.model.Post;
import inno.repository.PostRepository;
import inno.util.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/posts")
public class RestPostController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("id") Long id) {
        return postRepository.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable("id") Long id) {
        postRepository.delete(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Post savePost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.PATCH)
    public Post updatePost(@RequestBody Post post) {
        Post found = postRepository.findOne(post.getId());
        if (found == null) {
            throw new RecordNotFoundException();
        }
        return postRepository.save(post);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFound() {

    };

}



