package com.bbs.springbootbbsreview.controller;

import com.bbs.springbootbbsreview.domain.dto.ArticleDto;
import com.bbs.springbootbbsreview.domain.entity.Article;
import com.bbs.springbootbbsreview.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/articles")
@Slf4j
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @PostMapping("/posts")
    public String createNewArticle(ArticleDto articleDto){
        log.info(articleDto.toString());
        Article article = articleDto.toEntity();
        articleRepository.save(article);
        return "redirect:/articles/" + article.getId();

    }

    @GetMapping(value="/new")
    public String getNewArticleForm(){
        return "article/new";
    }

}
