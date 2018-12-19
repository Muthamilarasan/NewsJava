package com.stackroute.NewsApp.HttpUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.model.Articles;
import com.stackroute.NewsApp.model.NewsResponse;
import com.stackroute.NewsApp.repository.NewsRepository;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component
public class HttpClient {

  @Autowired
  private NewsRepository newsRepository;

  public NewsResponse getAllNewsFromServer() {

    try {
      DefaultHttpClient httpClient = new DefaultHttpClient();
      HttpGet getRequest = new HttpGet(
        "http://newsapi.org/v2/top-headlines?country=us&apikey=6109e8f0227444f9ae772f5c34ff50b3");
      getRequest.addHeader("accept", "application/json");

      HttpResponse response = httpClient.execute(getRequest);

      if (response.getStatusLine().getStatusCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
          + response.getStatusLine().getStatusCode());
      }
      //String responseString = new BasicResponseHandler().handleResponse(response);

      ObjectMapper objectMapper = new ObjectMapper();
      NewsResponse newsData = objectMapper.readValue(response.getEntity().getContent(), NewsResponse.class);

      return newsData;
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

}

