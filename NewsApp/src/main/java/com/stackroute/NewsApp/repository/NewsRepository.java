package com.stackroute.NewsApp.repository;

import com.stackroute.NewsApp.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, String> {

  public Optional<News> findByTitle(String title);

  public void deleteByTitle(String title);
}
