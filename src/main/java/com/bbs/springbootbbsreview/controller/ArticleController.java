package com.bbs.springbootbbsreview.controller;

import com.bbs.springbootbbsreview.domain.dto.ArticleDto;
import com.bbs.springbootbbsreview.domain.entity.Article;
import com.bbs.springbootbbsreview.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/articles")
@Slf4j
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value="/{id}/edit")
    public String getEditPage(@PathVariable Long id, Model model){
        Optional<Article> article = articleRepository.findById(id);
        if(article.isEmpty()){
            model.addAttribute("message", String.format("%d가 없습니다.", id));
            return "articles/error";
        }
        model.addAttribute("article", article.get());
        return "articles/edit";

    }


    @GetMapping(value="/list")
    public String getList(Model model){
        List<Article> allAricles = articleRepository.findAll();
        model.addAttribute("articles", allAricles);
        return "articles/list";
    }

    @GetMapping(value = "{id}")
    public String selectById(@PathVariable Long id, Model model){
        Optional<Article> article = articleRepository.findById(id);
        if(article.isEmpty()){
            return "articles/error";
        }
        model.addAttribute("article", article.get());
        return "articles/show";
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
        return "articles/new";
    }

}
