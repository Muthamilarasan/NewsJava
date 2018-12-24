package com.stackroute.NewsApp.service;

import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.domain.WishList;
import com.stackroute.NewsApp.exception.NewsAlreadyExistException;
import com.stackroute.NewsApp.exception.NewsNotFoundException;

import java.util.List;

public interface NewsService {

  List<News> getNewsList();

  News getParticularNew(Long id) throws NewsNotFoundException;

  News createNews(News news);

  News updateNews(Long id, News news) throws NewsNotFoundException;

  String deleteNews(Long id) throws NewsNotFoundException;

  String addToWishList(String userID, Long id) throws NewsNotFoundException;

  String removeFromWishList(String userID, Long id) throws NewsNotFoundException;

  List<WishList> getAllWishListOfUser(String userId) throws NewsNotFoundException;

}
