package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.dao.NoticeMapper;
import com.tustcs.matrix.entity.Notice;
import com.tustcs.matrix.service.NoticeService;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-7-31.
 */
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    @Resource
    NoticeMapper noticeMapper;


    @Override
    public List<Notice> showNotice(Integer pageNow) {
        List<Notice> noticeList;
        if(pageNow!=null){
            noticeList=noticeMapper.selectNoticeList((pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return noticeList;

    }

    @Override
    public boolean addNotice(Notice notice) {
        return noticeMapper.insertSelective(notice)>0;
    }

    @Override
    public boolean deleteNotice(Integer noticeId) {
        Notice notice=new Notice();
        notice.setNoticeId(noticeId);
        notice.setDeleteFlag(1);
        return noticeMapper.updateByPrimaryKeySelective(notice)>0;
    }

    @Override
    public boolean updateNotice(Notice notice) {
        if(notice.getNoticeId()>0){
           return noticeMapper.updateByPrimaryKeySelective(notice)>0;
        }
        return false;
    }

    @Override
    public Notice getNotice(Integer noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }
}
