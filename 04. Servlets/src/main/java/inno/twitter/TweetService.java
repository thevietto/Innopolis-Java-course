package inno.twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TweetService {

    private static int ids = 0;


    private List<Tweet> tweets = new ArrayList<Tweet>();

    public List<Tweet> getAll() {
        return tweets;
    }

    public boolean add(String message) {
        Tweet tweet = new Tweet();
        tweet.setMessage(message);
        tweet.setCreatedAt(new Date());
        tweet.setId(++ids);
        return tweets.add(tweet);
    }

    public Tweet getById(long id) {
        for (Tweet tweet : tweets) {
            if (tweet.getId() == id) {
                return tweet;
            }
        }
        return null;
    }

}
