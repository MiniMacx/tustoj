package com.tustcs.matrix.controller;

import com.tustcs.matrix.annotation.UserAccess;
import com.tustcs.matrix.config.Config;
import com.tustcs.matrix.dao.NoticeMapper;
import com.tustcs.matrix.entity.Notice;
import com.tustcs.matrix.service.NoticeService;
import com.tustcs.matrix.utils.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-7-31.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    NoticeService noticeService;

    @Resource
    NoticeMapper noticeMapper;

    @RequestMapping(value = "/query",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res queryNotice(Integer pageNow){
        Res res=new Res();
        List<Notice> noticeList=noticeService.showNotice(pageNow);
        if(noticeList.size()>0){
            res.setData(noticeList);
            res.setStatus(1);
            res.setMsg(String.valueOf(noticeMapper.selectNoticeCount()));
        }else {
            res.setMsg("数据为空");
            res.setStatus(0);
        }

        return res;
    }

    @RequestMapping(value = "/queryDetail",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res queryDetail(Integer noticeId){
        Res res=new Res();
        Notice notice=noticeService.getNotice(noticeId);
        if(notice!=null){
            res.setStatus(1);
            res.setMsg("notice detail");
            res.setData(notice);
        }
        else {
            res.setMsg("empty");
            res.setStatus(0);
        }
        return res;
    }

    @UserAccess(level = Config.SCHOOLLEADER)
    @RequestMapping(value = "/update",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res updateNotice(@RequestBody Notice notice){
        Res res=new Res();
        if(noticeService.updateNotice(notice)){
            res.setStatus(1);
            res.setMsg("success!");
        }else {
            res.setStatus(0);
            res.setMsg("error");
        }
        return res;
    }

    @UserAccess(level = Config.SCHOOLLEADER)
    @RequestMapping(value = "/delete",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res deleteNotice(Integer noticeId){
        Res res=new Res();
        if(noticeService.deleteNotice(noticeId)){
            res.setStatus(1);
            res.setMsg("success!");
        }else {
            res.setStatus(0);
            res.setMsg("error");
        }
        return res;
    }

    @UserAccess(level = Config.SCHOOLLEADER)
    @RequestMapping(value = "/insert",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res insertNotice(@RequestBody Notice notice){
        Res res=new Res();
        if(noticeService.addNotice(notice)){
            res.setStatus(1);
            res.setMsg("success");
        }else {
            res.setStatus(0);
            res.setMsg("error");
        }
        return res;
    }
}
