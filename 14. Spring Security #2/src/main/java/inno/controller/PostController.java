package inno.controller;

import inno.model.Post;
import inno.model.User;
import inno.repository.PostRepository;
import inno.security.SecurityUtils;
import inno.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostRepository postRepository;

//    @Autowired
//    CommentRepository commentRepository;

    @Autowired
    PostService postService;

    @RequestMapping
    public String getAllPosts(@RequestParam(value = "phrase", required = false) String phrase, ModelMap map) {
        List<Post> posts = postRepository.findAll();
        if (phrase != null) {
            posts = posts.stream().filter(p -> p.getText().contains(phrase)).collect(Collectors.toList());
        }
        map.addAttribute("posts", posts);
        return "posts/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewPostPage(ModelMap map) {
        map.addAttribute("post", new Post());
        return "posts/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewPost(@ModelAttribute @Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "posts/add";
        }
        postService.savePost(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable("id") Long id, ModelMap map) {
        Post post = postRepository.findOne(id);
        map.addAttribute("post", post);
        return "/posts/show";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") Long id) {
        Post post = postRepository.findOne(id);
        if (!userCanEditPost(post)) {
            throw new AccessDeniedException("Acces denied");
        }
        postRepository.delete(post);
        return "redirect:/posts";
    }

    //    @PostAuthorize("isAuthorized() and #map['post'].user.id eq principal.id")
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") Long id, ModelMap map) {
        Post post = postRepository.findOne(id);
        if (!userCanEditPost(post)) {
            throw new AccessDeniedException("Acces denied");
        }
        map.addAttribute("post", post);
        return "posts/edit";
    }

    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    public String savePost(@ModelAttribute @Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "posts/edit";
        }
        postService.savePost(post);


        return "redirect:/posts";
    }

    private boolean userCanEditPost(Post post) {
        User currentUser = SecurityUtils.getCurrentUser();
        return currentUser != null && post.getUser().getId().equals(currentUser.getId());
    }
}
