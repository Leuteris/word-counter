package gr.xe.challenge.dto;
//33
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
//1
public class WordCountResponse {
//commit1
    private String text;
    private long words;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal eurosAmount;

    public String getText() {
        return text;
    }//2

    public void setText(String text) {
        this.text = text;
    }

    public long getWords() {
        return words;
    }
//22
    public void setWords(long words) {
        this.words = words;
    }//33

    public BigDecimal getEurosAmount() {
        return eurosAmount;
    }

    public void setEurosAmount(BigDecimal eurosAmount) {
        this.eurosAmount = eurosAmount;
    }
}
//2
//3

/22
//44