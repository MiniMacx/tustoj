package com.tustcs.matrix.controller;

import com.tustcs.matrix.dao.NewsMapper;
import com.tustcs.matrix.entity.News;
import com.tustcs.matrix.service.NewsService;
import com.tustcs.matrix.utils.Page;
import com.tustcs.matrix.dto.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-10.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Resource
    NewsService newsService;

    @Resource
    NewsMapper newsMapper;

    @RequestMapping("/query")
    @ResponseBody
    public Res<List<News>> showNews(Integer pageNow){
        Res<List<News>> res=new Res<List<News>>();
        try {
            List<News> newsList = newsService.showNews(pageNow);
            res.setData(newsList);
            res.setMsg(String.valueOf(newsMapper.selectNewsCount()));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setMsg("数据为空");
            res.setStatus(0);
            return res;
        }
    }

    @RequestMapping("/queryByTitle")
    @ResponseBody
    public Res<List<News>> showNewsByTitle(Integer pageNow,String title){
        Res<List<News>> res=new Res<List<News>>();
        try {
            title=new String(title.getBytes("ISO-8859-1"), "UTF-8");
            List<News> newsList = newsService.showNewsByTitle(pageNow,title);
            res.setData(newsList);
            res.setMsg(String.valueOf(newsMapper.selectNewsCountUsingTitle(title)));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setMsg("数据为空");
            res.setStatus(0);
            return res;
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Res insertContest(@RequestBody News news){
        Res res=new Res();
        if(newsService.addNews(news)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Res updateContest(@RequestBody News news){
        Res res=new Res();
        if(newsService.updateNews(news)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Res deleteContest(Integer newsId){
        Res res=new Res();
        if(newsService.deleteNews(newsId)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

    @RequestMapping("/queryDetail")
    @ResponseBody
    public Res getDetail(Integer newsId){
        Res res=new Res();
        News news=newsService.getNews(newsId);
        if(news==null){
            res.setMsg("failed");
            res.setStatus(0);
        }else {
            res.setData(news);
            res.setStatus(1);
            res.setMsg("news detail");
        }
        return res;
    }
}
