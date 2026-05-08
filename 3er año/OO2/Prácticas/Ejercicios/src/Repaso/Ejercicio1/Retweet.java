package Repaso.Ejercicio1;

import java.time.LocalDateTime;

public class Retweet implements ITweet{
    private Tweet originalTweet;
    private Usuario user;
    private LocalDateTime publicationDate;

    public Retweet(Tweet aGoodTweet, Usuario user) {
     this.originalTweet = aGoodTweet;
     this.publishDate = LocalDateTime.now();
    }

    public String getText() {
        return originalTweet.getText();
    }

    public LocalDateTime getPublicationDate() {
        return publishDate;
    }
}
