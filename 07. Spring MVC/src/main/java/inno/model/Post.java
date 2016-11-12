package inno.model;

import java.util.Date;

/**
 * Created by vietto on 12.11.16.
 */
public class Post {

    private static long ids = 0;

    private Long id;
    private String title;
    private String text;
    private Date date;

    public Post() {
        this.id = ++ids;
        this.date = new Date();
    }

    public Post(String title, String text) {
        this();
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
