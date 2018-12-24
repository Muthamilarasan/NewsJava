package com.stackroute.NewsApp.service;

import com.stackroute.NewsApp.HttpUtils.HttpClient;
import com.stackroute.NewsApp.dao.NewsDao;
import com.stackroute.NewsApp.dao.WishListDoa;
import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.domain.WishList;
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
  private WishListDoa wishListDoa;

  @Autowired
  private HttpClient httpClient;

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

  @Override
  public News getParticularNew(Long id) throws NewsNotFoundException{

    return newsDao.getNewsWithId(id);
  }

  @Override
  public News createNews(News news) {

    return newsDao.createNews(news);
  }

  @Override
  public News updateNews(Long id, News news) throws NewsNotFoundException {

    return newsDao.updateNews(id, news);
  }

  @Override
  public String deleteNews(Long id) throws NewsNotFoundException {

    return newsDao.deleteNews(id);
  }

  @Override
  public String addToWishList(String userID, Long id) throws NewsNotFoundException {

    return wishListDoa.addNewsToWishList(id, userID);
  }

  @Override
  public String removeFromWishList(String userID, Long id) throws NewsNotFoundException {

    return wishListDoa.removeFromWishList(id, userID);
  }

  @Override
  public List<WishList> getAllWishListOfUser(String userID) throws NewsNotFoundException {

    return wishListDoa.getAllWishListOfUser(userID);
  }

}
