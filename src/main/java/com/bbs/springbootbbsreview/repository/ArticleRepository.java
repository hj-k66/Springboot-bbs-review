package com.bbs.springbootbbsreview.repository;

import com.bbs.springbootbbsreview.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
