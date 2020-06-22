package com.imdb.controller;

import com.imdb.entity.TitleBasics;
import com.imdb.repository.TitleBasicsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RestController
@RequestMapping(path = "/titles")
public class TitleBasicsController {

    private final TitleBasicsRepository titleBasicsRepository;

    public TitleBasicsController(TitleBasicsRepository titleBasicsRepository) {
        this.titleBasicsRepository = titleBasicsRepository;
    }

    @GetMapping("/{title}")
    Optional<TitleBasics> findByOriginalTitle(@PathVariable("title") String title) {
        return titleBasicsRepository.findByOriginalTitle(title);
    }
}