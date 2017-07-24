package com.tustcs.matrix.controller;

import com.tustcs.matrix.config.Config;
import com.tustcs.matrix.dao.NoticeMapper;
import com.tustcs.matrix.dto.Res;
import com.tustcs.matrix.entity.*;
import com.tustcs.matrix.service.IndexService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by L.key on 2017/6/10.
 */
@Controller
@RequestMapping(value = "index", produces = {"application/json;charset=UTF-8"})
public class IndexController {

    @Resource
    private IndexService indexService;

    @Resource
    private NoticeMapper noticeMapper;


    /**
     * 只查询最新插入的5条
     *
     * @return
     */
    @RequestMapping(value = "news", method = RequestMethod.POST)
    @ResponseBody
    public String getNews() {
        JSONObject jsonObject = new JSONObject();
        List<News> listNews = indexService.listNews();
        if (null == listNews || listNews.size() <= 0) {
            jsonObject.put("status", 0)
                    .put("msg", "查询新闻失败");
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("news", listNews)
                .put("status", 1);
        return Res.jsonToString(jsonObject);
    }




    /**
     * 只查询最新的5条公告
     *
     * @return 返回json字符串
     */
    @RequestMapping(value = "notice", method = RequestMethod.POST)
    @ResponseBody
    public String getNotice() {
        JSONObject jsonObject = new JSONObject();
        List<Notice> listNotice = indexService.listNotice();
        if (null == listNotice || listNotice.size() <= 0) {
            jsonObject.put("status", 0)
                    .put("msg", "查询公告失败");
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("notice", listNotice)
                .put("msg",noticeMapper.selectNoticeCount())
                .put("status", 1);
        return Res.jsonToString(jsonObject);
    }



    /**
     * topic表中查询行的数量
     *
     * @param page  查询页数
     * @return 返回json字符串
     */
    @RequestMapping(value = "list_discuss", method = RequestMethod.POST)
    @ResponseBody
    public String getListDiscuss(int page) {

        JSONObject jsonObject = new JSONObject();
        List<Topic> listTopic = indexService.listTopic((page-1)* Config.PAGE_NUM , Config.PAGE_NUM);
        if (null == listTopic || listTopic.size() <= 0) {
            jsonObject.put("status", 0)
                    .put("msg", "查询讨论列表失败");
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("listDiscuss", listTopic).
                put("status", 1);
        return Res.jsonToString(jsonObject);
    }



    /**
     * 依据topicId和评论时间降序查询回复topic的回复列表 返回json字符串
     *
     * @param topicId
     * @return
     */
    @RequestMapping(value = "discuss", method = RequestMethod.POST)
    @ResponseBody
    public String getDiscuss(int topicId) {
        JSONObject jsonObject = new JSONObject();
        List<Reply> listReply = indexService.listReply(topicId);
        if (null == listReply || listReply.size() <= 0) {
            jsonObject.put("status", 0)
                    .put("msg", "查询回复列表失败");
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("discuss", listReply)
                .put("status", 1);
        return Res.jsonToString(jsonObject);
    }



    /**
     * 查询指定行数的问题
     *
     * @param page 查询页数
     * @return
     */
    @RequestMapping(value = "problems", method = RequestMethod.POST)
    @ResponseBody
    public String getProblemList(int page) {
        JSONObject jsonObject = new JSONObject();
        List<ProblemWithBLOBs> listProblem = indexService.ListProblem((page-1)* Config.PAGE_NUM , Config.PAGE_NUM);
        if (null == listProblem || listProblem.size() <= 0) {
            jsonObject.put("status", 0)
                    .put("msg", "查询问题列表失败");
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("problems", listProblem)
                .put("status", 1);
        return Res.jsonToString(jsonObject);
    }





    /**
     * 依据问题标题模糊查询指定索引区域内的问题列表
     *
     * @param problemTitle 模糊标题关键字
     * @param page 查询页数
     * @return
     */
    @RequestMapping(value = "indistinct_problems", method = RequestMethod.POST)
    @ResponseBody
    public String getIndistinctProblem(String problemTitle, int page) {
        JSONObject jsonObject = new JSONObject();
        List<ProblemWithBLOBs> listProblemIndistinct = indexService.ListProblemIndistinct(problemTitle,(page-1)* Config.PAGE_NUM , Config.PAGE_NUM);
        if (null == listProblemIndistinct || listProblemIndistinct.size() <= 0) {
            jsonObject.put("status", 0)
                    .put("msg", "查不到问题");
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("indistinctProblems", listProblemIndistinct)
                .put("status", 1);
        return Res.jsonToString(jsonObject);
    }




    /**
     * 查询user表中排名前userNum个的人
     *
     * @param userNum
     * @return 返回每个人的信息列表
     */
    @RequestMapping(value = "ranking_list", method = RequestMethod.POST)
    @ResponseBody
    public String getRankingList(int userNum) {
        JSONObject jsonObject = new JSONObject();
        List listRankList = indexService.RankingList(userNum);
        if (null == listRankList || listRankList.size() <= 0) {
            jsonObject.put("status", 0)
                    .put("msg", "查询排行榜失败");
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("rankingList", listRankList)
                .put("status", 1);
        return Res.jsonToString(jsonObject);
    }
}
