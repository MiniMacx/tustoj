package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.News;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-10.
 */
public interface NewsService {
    List<News> showNews(Integer pageNow);

    List<News> showNewsByTitle(String title, Integer pageNow);
}
