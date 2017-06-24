package com.tustcs.matrix.utils;

/**
 * Created by polykickshaw on 17-6-6.
 */

import java.io.Serializable;

/**
 * 分页
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -3198048449643774660L;

    public static int pageSize = 20; // 每页显示记录的条数

    public static int getTotalPageCount(int totalCount){
        return totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1;
    }


}
