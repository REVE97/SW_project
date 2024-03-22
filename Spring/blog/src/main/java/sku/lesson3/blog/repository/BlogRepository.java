package sku.lesson3.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sku.lesson3.blog.domain.Article;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
