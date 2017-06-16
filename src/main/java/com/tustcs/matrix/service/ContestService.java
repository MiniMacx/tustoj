package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Contest;
<<<<<<< HEAD

=======
import com.tustcs.matrix.utils.Res;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
public interface ContestService {
<<<<<<< HEAD
    List<Contest> showContest(Integer pageNow);

    List<Contest> showContestByTitle(Integer pageNow,String title);
=======
    Res<List<Contest>> showContest(Integer pageNow);

    Res<List<Contest>> showContestByTitle(Integer pageNow,String title);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
}
