package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Solution;
<<<<<<< HEAD

=======
import com.tustcs.matrix.utils.Res;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
import java.util.List;

/**
 * Created by polykickshaw on 17-6-6.
 */
public interface SolutionService {
<<<<<<< HEAD
    List<Solution> showSolutionByUserId(Integer pageNow, String StringUserId);
=======
    Res<List<Solution>> showSolutionByUserId(Integer pageNow, String StringUserId);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
}
