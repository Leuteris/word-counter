package gr.xe.challenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
//1
public class WordCountResponse {

    private String text;
    private long words;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal eurosAmount;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getWords() {
        return words;
    }

    public void setWords(long words) {
        this.words = words;
    }

    public BigDecimal getEurosAmount() {
        return eurosAmount;
    }

    public void setEurosAmount(BigDecimal eurosAmount) {
        this.eurosAmount = eurosAmount;
    }
}
