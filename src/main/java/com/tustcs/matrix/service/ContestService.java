package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.utils.Res;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
public interface ContestService {
    Res<List<Contest>> showContest(Integer pageNow);

    Res<List<Contest>> showContestByTitle(Integer pageNow,String title);
}
