package com.tustcs.matrix.controller;

import com.tustcs.matrix.entity.News;
import com.tustcs.matrix.service.NewsService;
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

    @RequestMapping("/show/{pageNow}")
    @ResponseBody
    public Res<List<News>> showNews(HttpServletRequest request, @PathVariable("pageNow")Integer pageNow){
        Res<List<News>> res=new Res<List<News>>();
        return res;
    }

    @RequestMapping("/showbytitle/{pageNow}")
    @ResponseBody
    public Res<List<News>> showNewsByTitle(HttpServletRequest request,@PathVariable("pageNow") Integer pageNow){
        Res<List<News>> res=new Res<List<News>>();

        String title=request.getParameter("title");

        return res;
    }
}
