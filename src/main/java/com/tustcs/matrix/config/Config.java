package com.tustcs.matrix.config;

/**
 * Created by L.key on 2017/6/2.
 */
public class Config {
    public static final String CODEKEY = "MATRIXOJ";

    public static final String CHARSET = "UTF-8";

    public static final String FILED_NAME = "Login.Token1";

    public static final String FILED_PASSWORD = "Login.Token2";
    //登陆页面
    public static final String LOGIN  = "http://urp.tust.edu.cn"; ///userPasswordValidate.portal
    //个人主页
    public static final String OWN_INDEX = "http://urp.tust.edu.cn/index.portal";

    /**
     *解析学生信息的html
     *参考http://urp.tust.edu.cn/index.portal解析
     */
    //姓名所属标签
    public static final String NAME_DIV_ID = "topMenu";
    //姓名所属的具体标签
    public static final String NAME_TAGNAME = "li";
    //身份信息所属标签
    public static final String MSG_DIV_CLASS = ".portletContent";

    //limit分页
    public static final int PAGE_NUM= 20;


}
