package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.dao.NewsMapper;
import com.tustcs.matrix.entity.News;
import com.tustcs.matrix.service.NewsService;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-10.
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Resource
    NewsMapper newsMapper;

    @Override
    public List<News> showNews(Integer pageNow) {
        List<News> newsList;

        if(pageNow!=null){
            newsList=newsMapper.selectNewsList((pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return newsList;
    }

    @Override
    public List<News> showNewsByTitle(String title, Integer pageNow) {
        List<News> newsList;

        if(pageNow!=null){
            newsList=newsMapper.selectByTitle(title,(pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return newsList;
    }
}
