package com.bbs.springbootbbsreview.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
}
