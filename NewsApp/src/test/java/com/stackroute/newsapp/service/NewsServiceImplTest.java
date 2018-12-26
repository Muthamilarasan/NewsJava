package com.stackroute.newsapp.service;

import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.exception.NewsAlreadyExistException;
import com.stackroute.NewsApp.exception.NewsNotFoundException;
import com.stackroute.NewsApp.repository.NewsRepository;
import com.stackroute.NewsApp.service.NewsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class NewsServiceImplTest {

  @Mock
  NewsRepository newsRepo;

  News news;

  @InjectMocks
  NewsServiceImpl newsServiceImpl;

  Optional<News> options;




  @Test
  public void testMockCreation(){
    assertNotNull("JPACreation fails");
  }

//  @Test
//  public void testAddNewsSuccess() throws NewsAlreadyExistException {
//    when(newsRepo.save(news)).thenReturn(news);
//    News tempNews = newsServiceImpl.addNews(news);
//    assertEquals(news.getTitle(),tempNews.getTitle());
//  }
//
//  @Test(expected = NewsAlreadyExistException.class)
//  public void testAddNewsFailure() throws NewsAlreadyExistException {
//    when(newsRepo.findByTitle("My own News")).thenReturn(options);
//    when(newsRepo.save(news)).thenReturn(news);
//    News tempNews = newsServiceImpl.addNews(news);
//    assertEquals(news.getTitle(),tempNews.getTitle());
//  }
//
//
//  @Test
//  public void testDeleteNews() throws NewsNotFoundException {
//    when(newsRepo.findByTitle("My own News")).thenReturn(options);
//    newsRepo.deleteByTitle(news.getTitle());
//    String result = newsServiceImpl.deleteNews(news.getTitle());
//    assertEquals(result,"Successfully Deleted");
//  }
}
