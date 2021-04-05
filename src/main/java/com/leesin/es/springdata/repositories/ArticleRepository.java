package com.leesin.es.springdata.repositories;

import com.leesin.es.elasticSearchClient.es.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
    List<Article> findByTitle(String title);
    List<Article> findByTitleOrContent(String title, String content);
    // pageable 分页
    List<Article> findByTitleOrContent(String title, String content, Pageable pageable);
}
