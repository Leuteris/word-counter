package gr.xe.challenge.service;

import gr.xe.challenge.dto.WordCountResponse;
import gr.xe.challenge.util.Utils;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//test
@Service
public class WordService {

    private final static Pattern punctuationPattern = Pattern.compile("(\\p{Punct})+");
    private final static Pattern euroPattern = Pattern.compile("(?i)([0-9]+(?:[.,][0-9]+)?)\\s*(ευρώ?|ευρω|euro?|€)");

    public WordCountResponse countWords(String text) {
        long count = Arrays.stream(text.trim().split("\\s"))
                .filter(word -> word.length() > 1
                        && !punctuationPattern.matcher(word).matches())
                .count();
        WordCountResponse response = new WordCountResponse();
        response.setEurosAmount(matchEuroAmount(text));
        response.setText(text);
        response.setWords(count);
        return response;
    }
//test 5
    public WordCountResponse countWordsFromHtml(String html) {
        return countWords(Jsoup.parse(html).text());
    }

    private BigDecimal matchEuroAmount(String text) {
        Matcher euroMatcher = euroPattern.matcher(text);
        if (euroMatcher.find()) {
            return Utils.parseMoney(euroMatcher.group(1));
        }
        return null;
    }
}
