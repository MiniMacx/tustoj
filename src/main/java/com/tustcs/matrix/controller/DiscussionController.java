package com.tustcs.matrix.controller;

import com.tustcs.matrix.service.TopicService;
import com.tustcs.matrix.entity.Reply;
import com.tustcs.matrix.entity.Topic;
import com.tustcs.matrix.service.ReplyService;
import com.tustcs.matrix.utils.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-12.
 */
@Controller
@RequestMapping("/discussion")
public class DiscussionController {
    @Resource
    TopicService topicService;

    @Resource
    ReplyService replyService;

   // @RequestMapping("/topic")
   // class TopicClass{
        @RequestMapping("/show/{pageNow}")
        @ResponseBody
        Res<List<Topic>> showTopic(@PathVariable("pageNow") Integer pageNow){
            Res<List<Topic>> res=new Res<List<Topic>>();
            return res;
        }

        @RequestMapping("/showbytitle/{pageNow}")
        @ResponseBody
        Res<List<Topic>> showTopicByTitle(HttpServletRequest request,@PathVariable("pageNow") int pageNow){
            String title=request.getParameter("title");
            Res<List<Topic>> res=new Res<List<Topic>>();
            return res;
        }

        @RequestMapping("/showbyuserid/{pageNow}")
        @ResponseBody
        Res<List<Topic>> showTopicByUserId(HttpServletRequest request,@PathVariable("pageNow") int pageNow){
            String title=request.getParameter("userId");
            Res<List<Topic>> res=new Res<List<Topic>>();
            return res;
        }


        @RequestMapping("/showreply/{pageNow}")
        @ResponseBody
        Res<List<Reply>> showReply(@PathVariable("pageNow") Integer pageNow){
            Res<List<Reply>> res=new Res<List<Reply>>();
            return res;
        }
    //}


}
