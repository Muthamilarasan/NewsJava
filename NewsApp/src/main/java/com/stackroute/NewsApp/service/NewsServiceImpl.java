package com.stackroute.NewsApp.service;

import com.stackroute.NewsApp.HttpUtils.HttpClient;
import com.stackroute.NewsApp.dao.NewsDao;
import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.exception.NewsAlreadyExistException;
import com.stackroute.NewsApp.exception.NewsNotFoundException;
import com.stackroute.NewsApp.model.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

  @Autowired
  private NewsDao newsDao;

  @Autowired
  private HttpClient httpClient;


  /**
   * Desc: Get all the news
   *
   * @return List of News Object
   */
  @Override
  public List<News> getNewsList() {
    List<News> newsList = new ArrayList<>();
    try {
     newsList = newsDao.getAllNews();
      if (newsList.size() == 0){
        System.out.print("fecthing news list from external news API");
        NewsResponse newsData =  httpClient.getAllNewsFromServer();
        newsList = newsDao.storeNewsData(newsData);
      }
    } catch (Exception e){
      e.printStackTrace();

    }
    return newsList;
  }
}
