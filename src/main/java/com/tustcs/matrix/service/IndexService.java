package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.*;

import java.util.List;

/**
 * Created by L.key on 2017/6/10.
 */
public interface IndexService {

    List<News> listNews();

    List<Notice> listNotice();

    List<Topic> listTopic(int offSet, int rowSize);

    List<Reply> listReply(int topicId);

    List<ProblemWithBLOBs> ListProblem(int startPos, int pageSize);

    List<ProblemWithBLOBs> ListProblemIndistinct(String title, int startPos, int pageSize);

    List RankingList(int userNum);
}
