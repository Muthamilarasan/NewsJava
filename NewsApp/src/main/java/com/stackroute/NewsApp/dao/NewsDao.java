package com.stackroute.NewsApp.dao;

import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.model.Articles;
import com.stackroute.NewsApp.model.NewsResponse;
import com.stackroute.NewsApp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsDao {

  @Autowired
  NewsRepository newsRepository;


  public List<News> getAllNews(){
    List<News> newsList = newsRepository.findAll();
    return newsList;
  }

  public List<News> storeNewsData(NewsResponse newsData){

    List<Articles> article = newsData.getArticles();
    List<News> addedNews = new ArrayList<News>();
    for(int i=0; i< newsData.getArticles().size(); i++){
      System.out.println(article.get(i).getAuthor());
      News news = new News();
      news.setContent(article.get(i).getContent());
      news.setTitle(article.get(i).getTitle());
      news.setDescription(article.get(i).getDescription());
      news.setUrl(article.get(i).getUrl());
      news.setImageUrl(article.get(i).getUrlToImage());
      news.setPublishedDate(article.get(i).getPublishedAt());
      addedNews.add(newsRepository.save(news));
    }
 return addedNews;
  }
}
