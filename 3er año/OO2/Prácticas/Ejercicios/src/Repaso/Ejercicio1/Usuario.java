package Repaso.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String screenName;
    private List<ITweet> tweets;

    public Usuario(String coolName){
        this.setScreenName(coolName);
        this.tweets = new ArrayList<ITweet>();
    }

    public String getScreenName() {
        return this.screenName;
    }

    private void setScreenName(String coolName) {
        this.screenName = coolName;
    }

    public void newTweet(String tweetText) {

        if ((tweetText.size() >= 1) && (tweetText.size() <= 280)) {
            tweets.add(new Tweet(tweetText));
        } else {
            System.out.println("El texto no cumple con los requisitos de tamaño.");
        }
    }

    public void newRetweet(Tweet aCoolTweet) {
        tweets.add(new Retweet(aCoolTweet));
    }
}
