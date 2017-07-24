package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.dao.*;
import com.tustcs.matrix.entity.*;
import com.tustcs.matrix.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by L.key on 2017/6/10.
 */
@Service
public class IndexImpl implements IndexService {

    @Resource
    private NewsMapper NewsDao;

    @Resource
    private NoticeMapper noticeDao;

    @Resource
    private ReplyMapper replyDao;

    @Resource
    private ProblemMapper problemDao;

    @Resource
    private TopicMapper topicDao;

    @Resource
    private UserMapper userDao;

    public List<News> listNews() {
        return NewsDao.selectNewsList(0,5);
    }

    public List<Notice> listNotice() {
        return noticeDao.selectNoticeList(0,5);
    }

    public List<Topic> listTopic(int offSet, int rowSize){
        return topicDao.selectTopicList(offSet,rowSize);
    }

    public List<Reply> listReply(int topicId){
        return replyDao.selectByTopicId(topicId);
    }

    public List<ProblemWithBLOBs> ListProblem(int startPos, int pageSize){
        return problemDao.selectProblemList(startPos,pageSize);
    }

    public List<ProblemWithBLOBs> ListProblemIndistinct(String title, int startPos, int pageSize){
        return  problemDao.selectByTitle(title,startPos,pageSize);
    }

    public List RankingList(int userNum){
        List<User> rankingList = userDao.selectRankingList(0,userNum);
        List<Map<String,Object>> realRankList = new ArrayList<Map<String, Object>>();
        String rate;
        for (int i = 0;i<rankingList.size();i++){
            if (rankingList.get(i).getSubmit() == 0){
                rate = "0.00%";
            }else {
                BigDecimal bigDecimal = new BigDecimal((double)rankingList.get(i).getSolved()/rankingList.get(i).getSubmit());
                rate = String.valueOf(bigDecimal.setScale(4, //保留4位小数
                        BigDecimal.ROUND_HALF_UP) //执行四舍五入的规则
                        .doubleValue()*100)+"%"; //拼接成百分数
            }
           Map<String,Object> rankMap = new HashMap<String, Object>();
           rankMap.put("position",i+1);
           rankMap.put("userId",rankingList.get(i).getUserId());
           rankMap.put("nick",rankingList.get(i).getNick());
           rankMap.put("submit",rankingList.get(i).getSubmit());
           rankMap.put("solved",rankingList.get(i).getSolved());
           rankMap.put("rate",rate);
           realRankList.add(rankMap);
        }
        return realRankList;
    }
}
