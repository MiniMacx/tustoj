package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Topic;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-12.
 */
public interface TopicService {

    List<Topic> showTopic(Integer pageNow);

    List<Topic> showTopicByTitle(String title,Integer pageNow);

    List<Topic> showTopicByUserId(String userId,Integer pageNow);

    boolean addTopic(Topic topic);

    boolean updateTopic(Topic topic);

    boolean deleteTopic(Integer topicId);

    Topic getTopic(Integer topicId);
}
