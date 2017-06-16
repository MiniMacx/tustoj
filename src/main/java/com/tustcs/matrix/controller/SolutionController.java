package com.tustcs.matrix.controller;

<<<<<<< HEAD
import com.tustcs.matrix.dao.UserMapper;
import com.tustcs.matrix.entity.User;
import com.tustcs.matrix.entity.Solution;
=======
import com.tustcs.matrix.entity.Solution;
import com.tustcs.matrix.entity.User;
import com.tustcs.matrix.dao.UserMapper;
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
import com.tustcs.matrix.service.SolutionService;
import com.tustcs.matrix.utils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
=======
import org.springframework.ui.Model;
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-6.
 */
@Controller
@RequestMapping("/solution")
public class SolutionController {
    @Autowired
    SolutionService solutionService;

    @Autowired
    UserMapper userMapper;

<<<<<<< HEAD
    @RequestMapping(value = "/show/{loginUserId}/{pageNow}",method = RequestMethod.GET)
=======
    @RequestMapping(value = "/showsolution/{loginUserId}/{pageNow}",method = RequestMethod.GET)
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
    @ResponseBody
    public Res showSolution(HttpServletRequest request, @PathVariable("pageNow") Integer pageNow,
                            @PathVariable("loginUserId") String loginUserId){
        // 取得SESSION中的loginUser
        Res<List<Solution>> res= new Res<List<Solution>>();
        User loginUser=userMapper.selectByPrimaryKey(loginUserId);
      //  User loginUser = (User) request.getSession().getAttribute("loginUser");
        // 判断SESSION是否失效
        if (loginUser == null || "".equals(loginUser)) {
            res.setMsg("error");
            return res;
        }
        //此处的productService是注入的IProductService接口的对象
<<<<<<< HEAD

=======
        res=solutionService.showSolutionByUserId(pageNow,loginUserId);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
        return res;
    }
}
