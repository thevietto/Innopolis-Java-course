package inno.util.validators;


import inno.model.Post;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PostValidatorTest {

    private BeanPropertyBindingResult result;
    private String title;

    public PostValidatorTest(String title) {
        this.title = title;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> result = new ArrayList<>();
        result.add(new Object[]{"1234"});
        result.add(new Object[]{"12345"});
        result.add(new Object[]{"123456"});
        result.add(new Object[]{"1234567"});
        return result;
    }

//    @BeforeClass
//    @AfterClass
//    public static void beforeClass() {
//
//    }

    @Before
    public void setUp() {
        PostValidator validator = new PostValidator();
        Post post = new Post();
        post.setTitle(title);
        result = new BeanPropertyBindingResult(post, "post");
        validator.validate(post, result);
    }

    @After
    public void tearDown() {
    }


//    @Test(expected = RuntimeException.class)
//    @Test(timeout = 500)
    @Test
    public void testTitleLengthGreaterThanFive() {
        Assume.assumeNotNull(result.getFieldError("title"));
        Assert.assertEquals("Заголовок должн иметь минимум 5 симоволов",
                result.getFieldError("title").getDefaultMessage());

    }


}
