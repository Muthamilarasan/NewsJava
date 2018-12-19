package com.stackroute.newsapp.repository;

import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.repository.NewsRepository;
import org.h2.util.New;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class NewsRepositoryTest {

  @Autowired
  NewsRepository repo;

  @Test
  public void testSaveNews() throws Exception {

    repo.save(new News(1, "My own News", "Test", "localhost:8888", null, null, null));
    Optional<News> news = repo.findByTitle("My own News");
    assertThat(news.isPresent()).isEqualTo(true);

  }

  @Test
  public void testGetNews() throws Exception {
    repo.save(new News(1, "My own News", "Test", "localhost:8888", null, null, null));
    List<News> news = repo.findAll();
    assertThat(news.size()).isGreaterThan(0);
  }


  @Test
  public void testDeleteNews() throws Exception {
    repo.save(new News(1, "My own News", "Test", "localhost:8888", null, null, null));
    Optional<News> news = repo.findByTitle("My own News");
    assertThat(news.isPresent()).isEqualTo(true);
    repo.deleteByTitle("My own News");
    assertEquals(Optional.empty(),repo.findByTitle("My own News"));
  }
}
