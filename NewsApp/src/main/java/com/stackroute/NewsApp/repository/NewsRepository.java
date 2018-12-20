package com.stackroute.NewsApp.repository;

import com.stackroute.NewsApp.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

  public News findByNewsId(Long id);
}
