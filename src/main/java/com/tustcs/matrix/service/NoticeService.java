package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Notice;

import java.util.List;

/**
 * Created by polykickshaw on 17-7-31.
 */
public interface NoticeService {
    List<Notice> showNotice(Integer pageNow);

    boolean addNotice(Notice notice);

    boolean deleteNotice(Integer noticeId);

    boolean updateNotice(Notice notice);

    Notice getNotice(Integer noticeId);
}
