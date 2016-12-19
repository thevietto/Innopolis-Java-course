package inno.service.impl;

import inno.model.Post;
import inno.model.User;
import inno.repository.PostRepository;
import inno.security.SecurityUtils;
import inno.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository repository;

    @Transactional
    @Override
    public void savePost(Post post) {
        User user = SecurityUtils.getCurrentUser();
        post.setUser(user);
        // TODO использовать PostForm
        repository.save(post);
    }
}
