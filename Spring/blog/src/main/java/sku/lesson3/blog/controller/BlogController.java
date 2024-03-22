package sku.lesson3.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sku.lesson3.blog.domain.Article;
import sku.lesson3.blog.dto.AddArticleRequest;
import sku.lesson3.blog.service.BlogService;

@RequiredArgsConstructor
@Controller
public class BlogController {
    private final BlogService blogService;

    @PostMapping(value = "/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
