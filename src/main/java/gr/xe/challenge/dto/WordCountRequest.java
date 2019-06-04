package gr.xe.challenge.dto;

import javax.validation.constraints.NotNull;

public class WordCountRequest {

    @NotNull
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
