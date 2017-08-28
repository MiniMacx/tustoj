package com.tustcs.matrix.controller;

import com.tustcs.matrix.dao.ReplyMapper;
import com.tustcs.matrix.dao.TopicMapper;
import com.tustcs.matrix.service.TopicService;
import com.tustcs.matrix.entity.Reply;
import com.tustcs.matrix.entity.Topic;
import com.tustcs.matrix.service.ReplyService;
import com.tustcs.matrix.utils.Res;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-12.
 */
@Controller
public class DiscussionController {
    @Resource
    TopicService topicService;

    @Resource
    ReplyService replyService;

    @Resource
    ReplyMapper replyMapper;

    @Resource
    TopicMapper topicMapper;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

        @RequestMapping(value = "/topic/query",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        Res<List<Topic>> showTopic(Integer pageNow){
            Res<List<Topic>> res=new Res<List<Topic>>();
            try {
                List<Topic> topicList=topicService.showTopic(pageNow);
                if(topicList.size()>0){
                    res.setMsg(String.valueOf(topicMapper.selectCount())).setStatus(1).setData(topicList);
                }else {
                    res.setMsg("数据为空").setStatus(1);
                }
                return res;
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }

        }

        @RequestMapping(value = "/topic/queryByProblemId",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        Res<List<Topic>> showTopicByProblemId(Integer problemId,Integer pageNow){
            Res<List<Topic>> res=new Res<List<Topic>>();
            try {
                List<Topic> topicList=topicService.showTopicByProblemId(problemId,pageNow);
                if(topicList.size()>0){
                    res.setMsg(String.valueOf(topicMapper.selectTopicCountUsingProblemId(problemId))).setStatus(1).setData(topicList);
                }else {
                    res.setMsg("数据为空").setStatus(1);
                }
                return res;
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }

        }

        @RequestMapping(value = "/topic/queryByContestId",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        Res<List<Topic>> showTopicByContestId(Integer contestId,Integer pageNow){
            Res<List<Topic>> res=new Res<List<Topic>>();
            try {
                List<Topic> topicList=topicService.showTopicByContestId(contestId,pageNow);
                if(topicList.size()>0){
                    res.setMsg(String.valueOf(topicMapper.selectTopicCountUsingContestId(contestId))).setStatus(1).setData(topicList);
                }else {
                    res.setMsg("数据为空").setStatus(1);
                }
                return res;
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }

        }


        @RequestMapping(value = "/topic/insert",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        public Res insertTopic(@RequestBody Topic topic){
            Res res=new Res();
            try {
                if(topicService.addTopic(topic)){
                    res.setStatus(1).setMsg("success!");
                }else {
                    res.setStatus(0).setMsg("insert failed");
                }
                return res;
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }

        }

        @RequestMapping(value = "/topic/update",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        public Res updateTopic(@RequestBody Topic topic){
            Res res=new Res();
            try {
                if(topicService.updateTopic(topic)){
                    res.setStatus(1).setMsg("success!");
                }else {
                    res.setStatus(0).setMsg("update failed");
                }
                return res;
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }
        }

        @RequestMapping(value = "/topic/delete",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        public Res deleteTopic(Integer topicId){
            Res res=new Res();
            try {
                if(topicService.deleteTopic(topicId)){
                    res.setStatus(1).setMsg("success!");
                }else {
                    res.setStatus(0).setMsg("delete failed");
                }
                return res;
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }
        }

        @RequestMapping(value = "/topic/queryDetail",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        public Res queryTopicDetail(Integer topicId){
            Res res=new Res();
            try {
                Topic topic=topicService.getTopic(topicId);
                if(topic!=null){
                    return res.setMsg("topic").setStatus(1).setData(topic);
                }
                return res.setMsg("empty").setStatus(0);
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }

        }

        @RequestMapping(value = "/reply/query",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        public Res queryReplyList(Integer topicId,Integer pageNow){
            Res res=new Res();
            try {
                List<Reply> replyList=replyService.showReplyByTopicId(topicId,pageNow);
                res.setMsg(String.valueOf(replyMapper.selectReplyCount(topicId))).setStatus(1).setData(replyList);
                return res;
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }
        }


        @RequestMapping(value = "/reply/insert",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        public Res insertReply(@RequestBody Reply reply){
            Res res=new Res();
            try {
                if(replyService.addReply(reply)){
                    return res.setStatus(1).setMsg("success!");
                }
                return res.setStatus(0).setMsg("failed");
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }
        }

        @RequestMapping(value = "/reply/delete",method = RequestMethod.POST,
                produces =("application/json;charset=UTF-8"))
        @ResponseBody
        public Res deleteReply(Integer replyId){
            Res res=new Res();
            try {
                if(replyService.deleteReply(replyId)){
                    return res.setStatus(1).setMsg("success!");
                }
                return res.setStatus(0).setMsg("failed");
            }
            catch (Exception e){
                logger.error(e.getMessage(),e);
                return res.setStatus(-1).setMsg("error");
            }
        }


}
