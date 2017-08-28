package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.dao.*;
import com.tustcs.matrix.dto.ContestDTO;
import com.tustcs.matrix.dto.ContestProblemDTO;
import com.tustcs.matrix.dto.ContestSum;
import com.tustcs.matrix.dto.Exposer;
import com.tustcs.matrix.entity.*;
import com.tustcs.matrix.enums.ContestEnums;
import com.tustcs.matrix.service.ContestService;
import com.tustcs.matrix.utils.DateUtils;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by polykickshaw on 17-6-9.
 */
@Service
@Transactional
public class ContestServiceImpl implements ContestService {
    @Resource
    ContestMapper contestMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    ProblemMapper problemMapper;

    @Resource
    UserContestMapper userContestMapper;

    @Resource
    ContestProblemMapper contestProblemMapper;

    @Resource
    SolutionMapper solutionMapper;


    private final String salt="sajlkdaj@#$k*S&ds###ksjdlk19970815";

    @Override
    public List<Contest> showContest(Integer pageNow) {

        List<Contest> contestList;

        if(pageNow!=null){
            contestList=contestMapper.selectContestList((pageNow - 1) * Page.pageSize,Page.pageSize);
            return contestList;
        }else {
            return null;
        }

        }

    @Override
    public List<Contest> showContestByTitle(Integer pageNow, String title) {
        List<Contest> contestList;

        if(pageNow!=null&&title!=null){
            contestList=contestMapper.selectByTitle(title,(pageNow - 1) * Page.pageSize,Page.pageSize);
            return contestList;
        }else {
            return null;
        }


        }


    @Override
    public boolean addContest(ContestDTO contestDTO) {

        if(contestMapper.insertSelective(contestDTO)>0){
            Integer contestId=contestDTO.getContestId();
            List<Integer> contestProblemList=contestDTO.getContestProblem();
            if(contestId!=null){
                for (Integer problems:
                        contestProblemList) {
                    contestProblemMapper.insert(contestId,problems,0);
                }
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean deleteContest(Integer contestId) {
        Contest contest=new Contest();
        contest.setDeleteFlag(1);
        contest.setContestId(contestId);
        return contestMapper.updateByPrimaryKeySelective(contest)>0;
    }

    @Override
    public boolean updateContest(Contest contest) {
        if(contest.getContestId()>0)
            return contestMapper.updateByPrimaryKeySelective(contest)>0;
        return false;
    }

    @Override
    public Contest getContest(Integer contestId) {
        return contestMapper.selectByPrimaryKey(contestId);
    }

    @Override
    public boolean enrollContest(String userId,Integer contestId) {
        UserContest userContest = new UserContest();
        boolean flag = true;
        userContest.setContestId(contestId);
        userContest.setUserId(userId);
        userContest.setScore(0);
        if (contestMapper.updateEnrollNum(contestId) > 0 &&
                userContestMapper.insert(userContest) > 0){
            return flag;
        }
        flag=false;
        return flag;

    }

    @Override
    public Exposer exportContestUrl(Integer contestId) {
        Contest contest=contestMapper.selectByPrimaryKey(contestId);
//        if(!userId.equals(userMapper.selectByPrimaryKey(userId))||
//                userContestMapper.selectContest(contestId,userId)>0){
//            return new Exposer(false,contestId);
//        }

        if(contest==null){
            return new Exposer(false,null);
        }
        Date startTime=contest.getStartTime();
        Date endTime=contest.getEndTime();

        Date nowTime=new Date();
        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, contestId,nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        List<Integer> problemList=contestProblemMapper.selectProblemId(contestId);
        String md5=getMD5(contestId);
        return new Exposer(true,md5,contestId,problemList);
    }

    private String getMD5(int exportId) {
        String base = exportId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    public List<ContestProblemDTO> getContestProblem(Integer contestId) {
        return contestProblemMapper.selectProblemsForContest(contestId);
    }

    @Override
    public ContestSum execution(Integer contestId, String userId, String md5) {

        try {
            Integer sumScore = 0;
            Date date=new Date();
            if (md5 == null || !md5.equals(getMD5(contestId))) {
                return new ContestSum(contestId, userId, ContestEnums.MD5_FAILED, false);
            }
            if (userContestMapper.selectContest(contestId, userId) <= 0) {
                return new ContestSum(contestId, userId, ContestEnums.NOT_ENROLLED, false);
            }
            if(contestMapper.selectByPrimaryKey(contestId).getEndTime().before(date)){
                return new ContestSum(contestId,userId,ContestEnums.END,false);
            }
            List<ContestProblemDTO> problemList=getContestProblem(contestId);
            for (ContestProblemDTO problem:
                 problemList) {
                if(problem.getResult()==4){//4:AC
                    sumScore+=100/problemList.size();
                }
            }
            return new ContestSum(contestId, userId, ContestEnums.SUCCESS,problemList , sumScore, true);

        }catch (Exception e){
            e.printStackTrace();
            return new ContestSum(contestId,userId,ContestEnums.SYSTEM_ERROR,false);
        }
    }
}
