package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Solution;
import com.tustcs.matrix.utils.Res;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-6.
 */
public interface SolutionService {
    Res<List<Solution>> showSolutionByUserId(Integer pageNow, String StringUserId);
}
