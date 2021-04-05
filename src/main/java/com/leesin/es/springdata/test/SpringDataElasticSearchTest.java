package com.leesin.es.springdata.test;

// 这个其实应该是 springdata.entity，但是会报错，先这样吧。
import com.leesin.es.elasticSearchClient.es.Article;
import com.leesin.es.springdata.repositories.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataElasticSearchTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndex() throws Exception {
        //创建索引，并配置映射关系
        template.createIndex(Article.class);
        //配置映射关系
        //template.putMapping(Article.class);
    }

    @Test
    public void addDocument() throws Exception {
        for (int i = 10; i <= 20; i++) {
            //创建一个Article对象
            Article article = new Article();
            article.setId(i);
            article.setTitle("【图解】习近平寄语中俄青少年" + i);
            article.setContent("盛会再携手—各国政要高度评价东博会和商务与投资峰会");
            //把文档写入索引库
            articleRepository.save(article);
        }
    }
    @Test
    public void deleteDocumentById() throws Exception {
        articleRepository.deleteById(1l);
        //全部删除
        //articleRepository.deleteAll();
    }

    @Test
    public void findAll() throws Exception {
        Iterable<Article> articles = articleRepository.findAll();
        articles.forEach(a-> System.out.println(a));
    }
    @Test
    public void testFindById() throws Exception {
        Optional<Article> optional = articleRepository.findById(1l);
        Article article = optional.get();
        System.out.println(article);
    }

    @Test
    // template的缺点，"maven是一个工程构建工具" 有maven但是包含maven的记录没有出来，因为template是and的关系，即都需要包含。
    public void testFindByTitle() throws Exception {
        List<Article> list = articleRepository.findByTitle("maven是一个工程构建工具");
        list.stream().forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindByTitleOrContent() throws Exception {
        Pageable pageable = PageRequest.of(1, 15);
        articleRepository.findByTitleOrContent("maven", "商务与投资", pageable)
                .forEach(a-> System.out.println(a));
    }

    @Test
    // 所以通过NativeSearchQuery使用es默认的查询 通过queryString即可
    public void testNativeSearchQuery() throws Exception {
        //创建一个查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("maven是一个工程构建工具").defaultField("title"))
                .withPageable(PageRequest.of(0, 15))
                .build();
        //执行查询
        List<Article> articleList = template.queryForList(query, Article.class);
        articleList.forEach(a-> System.out.println(a));
    }








}
