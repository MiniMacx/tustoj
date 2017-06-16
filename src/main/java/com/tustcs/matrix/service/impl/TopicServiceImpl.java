package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.dao.TopicMapper;
import com.tustcs.matrix.entity.Topic;
import com.tustcs.matrix.service.TopicService;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-12.
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {
    @Resource
    TopicMapper topicMapper;

    @Override
    public List<Topic> showTopic(Integer pageNow) {

        List<Topic> topicList;

        if(pageNow!=null){
            topicList=topicMapper.selectTopicList((pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return topicList;
    }


    @Override
    public List<Topic> showTopicByTitle(String title, Integer pageNow) {

        List<Topic> topicList;

        if(pageNow!=null){
            topicList=topicMapper.selectByTitle(title,(pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return topicList;
    }

    @Override
    public List<Topic> showTopicByUserId(String userId, Integer pageNow) {
        List<Topic> topicList;

        if(pageNow!=null){
            topicList=topicMapper.selectByUserId(userId,(pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return topicList;
    }
}
