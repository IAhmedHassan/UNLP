package Repaso.Ejercicio1;

import java.time.LocalDateTime;

public class Tweet implements ITweet{
    private String text;
    private LocalDateTime PublicationDate;
    private Usuario user;

    public Tweet(String text, Usuario user) {
        this.setText(text);
        this.PublicationDate = LocalDateTime.now();
        this.user = user;
    }

    public String getText() {
        return this.text;
    }

    private void setText(String text){
        this.text = text;
    }

    public LocalDateTime getPublicationDate() { return this.PublicationDate; }

}
