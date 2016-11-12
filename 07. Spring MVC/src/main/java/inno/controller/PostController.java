package inno.controller;

import inno.model.Post;
import inno.repository.PostRepository;
import inno.util.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostRepository repository;

    @Autowired
    PostValidator validator;

    @RequestMapping
    public String getAllPosts(@RequestParam(value = "phrase", required = false) String phrase, ModelMap map) {
        List<Post> posts = repository.findAll();
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
    public String addNewPost(@ModelAttribute Post post, BindingResult result) {
        validator.validate(post, result);
        if (result.hasErrors()) {
            return "posts/add";
        }
        repository.add(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable("id") Long id, ModelMap map) {
        map.addAttribute("post", repository.find(id));
        return "/posts/show";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") Long id, ModelMap map) {
        repository.remove(id);
        return "redirect:/posts";
    }

}
