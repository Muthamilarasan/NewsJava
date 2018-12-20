package com.stackroute.NewsApp.dao;

import com.stackroute.NewsApp.domain.News;
import com.stackroute.NewsApp.domain.WishList;
import com.stackroute.NewsApp.exception.NewsNotFoundException;
import com.stackroute.NewsApp.repository.NewsRepository;
import com.stackroute.NewsApp.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishListDoa {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private NewsDao newsDao;

    public String addNewsToWishList(Long id, String userId) throws NewsNotFoundException {

        News news =  newsDao.getNewsWithId(id);
        if(news != null) {
            WishList wishList = new WishList();
            wishList.setNewsId(id);
            wishList.setUserId(userId);
            WishList wishListData =  wishListRepository.checkwishList(id, userId);
            System.out.print("wishListData" + wishListData);
            if(wishListData == null){
                wishListRepository.save(wishList);
            } else {
                throw new NewsNotFoundException("News has been wished already for the user newsid  :" + id);
            }
        } else {
            throw new NewsNotFoundException("Data Not availabe for the newsid :" + id);
        }
        return "Success";
    }

    public String removeFromWishList(Long id, String userId) throws NewsNotFoundException {

        News news =  newsDao.getNewsWithId(id);
        if(news != null) {
            wishListRepository.removeNews(id, userId);
        } else {
            throw new NewsNotFoundException("Data Not availabe for the newsid :" + id);
        }
        return "Success";
    }
}
