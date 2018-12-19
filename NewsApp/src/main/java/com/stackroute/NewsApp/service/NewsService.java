package com.stackroute.NewsApp.service;

import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.exception.NewsAlreadyExistException;
import com.stackroute.NewsApp.exception.NewsNotFoundException;

import java.util.List;

public interface NewsService {

  List<News> getNewsList();


}
