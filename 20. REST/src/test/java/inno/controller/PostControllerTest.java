package inno.controller;


import inno.model.Post;
import inno.repository.PostRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

public class PostControllerTest {

    PostController controller;
    PostRepository repository;
    ModelMap map;



    @Before
    public void setUp() {
        controller = new PostController();
        repository = Mockito.mock(PostRepository.class);
        controller.postRepository = repository;

        map = new ModelMap();
    }

    @Test
    public void testPostFound() throws Exception {
        Post post = new Post();
        Mockito.when(repository.findOne(1L)).thenReturn(post);
        controller.showPost(1L, map);
        Assert.assertSame(post, map.get("post"));
    }

    @Test(expected = Exception.class)
    public void testPostNotFound() throws Exception {
        controller.showPost(2L, map);
    }

    @Test
    public void testControllerGoesToRepo() throws Exception {
        Mockito.when(repository.findOne(3L)).thenReturn(new Post());
        controller.showPost(3L, map);
        Mockito.verify(repository, Mockito.times(1)).findOne(3L);
    }

}
