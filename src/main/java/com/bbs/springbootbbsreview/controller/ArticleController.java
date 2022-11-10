package com.bbs.springbootbbsreview.controller;

import com.bbs.springbootbbsreview.domain.dto.ArticleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/articles")
public class ArticleController {

    @PostMapping("/posts")
    public String createNewArticle(ArticleDto articleDto){

    }

    @GetMapping(value="/new")
    public String getNewArticleForm(){
        return "article/new";
    }

}
