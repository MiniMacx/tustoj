package com.tustcs.matrix.controller;

import com.tustcs.matrix.entity.News;
import com.tustcs.matrix.service.NewsService;
import com.tustcs.matrix.utils.Page;
import com.tustcs.matrix.utils.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-10.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Resource
    NewsService newsService;

    @RequestMapping("/queryNews")
    @ResponseBody
    public Res<List<News>> showNews(Integer pageNow){
        Res<List<News>> res=new Res<List<News>>();
        try {
            List<News> newsList = newsService.showNews(pageNow);
            res.setData(newsList);
            res.setMsg(String.valueOf(newsList.size() / Page.pageSize));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setMsg("failed");
            res.setStatus(0);
            return res;
        }
    }

    @RequestMapping("/queryByTitle")
    @ResponseBody
    public Res<List<News>> showNewsByTitle(Integer pageNow,String title){
        Res<List<News>> res=new Res<List<News>>();
        try {
            List<News> newsList = newsService.showNewsByTitle(pageNow,title);
            res.setData(newsList);
            res.setMsg(String.valueOf(newsList.size() / Page.pageSize));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setMsg("failed");
            res.setStatus(0);
            return res;
        }
    }
}
