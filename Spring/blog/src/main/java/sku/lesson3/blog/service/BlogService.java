package sku.lesson3.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sku.lesson3.blog.domain.Article;
import sku.lesson3.blog.dto.AddArticleRequest;
import sku.lesson3.blog.repository.BlogRepository;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
