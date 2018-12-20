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

  @RequestMapping(method = RequestMethod.GET, value = "/news/{id}")
  public ResponseEntity<?> getParticularNew(@PathVariable Long id)  {
    System.out.println("Inside Get Particular New Controller function");
    try {
      return new ResponseEntity<News>(newsService.getParticularNew(id), HttpStatus.OK);
    } catch (NewsNotFoundException e) {
      System.out.println("Inside Get NewsNotFoundException for Particular New Controller function");
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

  @RequestMapping(method = RequestMethod.POST, value = "/news")
  public ResponseEntity<News> createNews(@RequestBody News news) {
    System.out.println("Inside create news Controller function");
    return new ResponseEntity<News>(newsService.createNews(news), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/news/{id}")
  public ResponseEntity<?> updateNews(@RequestBody News news, @PathVariable Long id) {
    System.out.println("Inside updateNews Controller function");
    try {
      return new ResponseEntity<News>(newsService.updateNews(id, news), HttpStatus.OK);
    } catch (NewsNotFoundException e) {
      System.out.println("Inside NewsNotFoundException for updateNews Controller function");
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/news/{id}")
  public ResponseEntity<String> deleteNews(@PathVariable Long id) {
    System.out.println("Inside deleteNews Controller function");
    try {
      return new ResponseEntity<String>(newsService.deleteNews(id), HttpStatus.OK);
    } catch (NewsNotFoundException e) {
      System.out.println("Inside  NewsNotFoundException for deleteNews  Controller function");
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

  @RequestMapping(method = RequestMethod.POST, value = "/news/addToWishList/{id}")
  public ResponseEntity<String> addToWishList(@RequestHeader String userID, @PathVariable Long id) {
    System.out.println("Inside add news to WishList Controller function");
    try {
      return new ResponseEntity<String>(newsService.addToWishList(userID, id), HttpStatus.OK);
    } catch (NewsNotFoundException e) {
      System.out.println("Inside NewsNotFoundException for addToWishList  Controller function");
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/news/removeFromWishList/{id}")
  public ResponseEntity<String> removeFromWishList(@RequestHeader String userID, @PathVariable Long id) {
    System.out.println("Inside remove news From WishList Controller function");
    try {
      return new ResponseEntity<String>(newsService.removeFromWishList(userID, id), HttpStatus.OK);
    } catch (NewsNotFoundException e) {
      System.out.println("Inside NewsNotFoundException for removeFromWishList  Controller function");
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
  }


}
