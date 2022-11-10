package com.bbs.springbootbbsreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/articles")
public class ArticleController {

    @GetMapping(value="/new")
    public String getNewArticleForm(){
        return "article/new";
    }

}
