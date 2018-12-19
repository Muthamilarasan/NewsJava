package com.stackroute.NewsApp.controller;

import com.stackroute.NewsApp.HttpUtils.HttpClient;
import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.exception.NewsAlreadyExistException;
import com.stackroute.NewsApp.exception.NewsNotFoundException;
import com.stackroute.NewsApp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NewsController {

  @Autowired
  private NewsService newsService;

  @Autowired
  HttpClient httpClient;

  /**
   * Desc: Get all the news
   *
   * @return List of News Object
   */
  @RequestMapping(method = RequestMethod.GET, value = "/news")
  public ResponseEntity<List<News>> getAllNews() {
    System.out.println("Inside Get all news Controller function");
    return new ResponseEntity<List<News>>(newsService.getNewsList(), HttpStatus.OK);
  }
}
