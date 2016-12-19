package inno.util.converters;

import inno.model.Post;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

public class PostConverter extends AbstractHttpMessageConverter<Post> {
    @Override
    protected boolean supports(Class<?> clazz) {
        return Post.class.equals(clazz);
    }

    @Override
    protected Post readInternal(Class<? extends Post> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        inputMessage.getBody();
        return new Post();
    }

    @Override
    protected void writeInternal(Post post, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody().write("Ну вроде всё ок".getBytes());
    }
}
