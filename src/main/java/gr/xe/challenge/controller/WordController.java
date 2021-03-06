package gr.xe.challenge.controller;

import gr.xe.challenge.dto.WordCountRequest;
import gr.xe.challenge.dto.WordCountResponse;
import gr.xe.challenge.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
//TEST
@RestController
@RequestMapping("/word")
public class WordController {
//
    @Autowired
    WordService wordService;..

..
    //test1
...
    @PostMapping("/count")
    public WordCountResponse count(@Valid @RequestBody WordCountRequest request) {
        return wordService.countWords(request.getText());
    }

    //test


    @PostMapping("/countHtml")
    public WordCountResponse countHtml(@Valid @RequestBody WordCountRequest request) {
        return wordService.countWordsFromHtml(request.getText());
    }
}
//TEST3 3