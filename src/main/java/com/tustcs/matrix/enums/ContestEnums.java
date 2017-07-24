package com.tustcs.matrix.enums;

import com.tustcs.matrix.entity.Contest;

/**
 * Created by polykickshaw on 17-7-21.
 */
public enum  ContestEnums {

    SUCCESS(1,"更新成功"),
    END(0,"比赛结束"),
    NOT_ENROLLED(-1,"未报名"),
    MD5_FAILED(-2,"验证失败"),
    SYSTEM_ERROR(-3,"系统异常");

    private int state;

    private String stateInfo;

    ContestEnums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }



    public String getStateInfo() {
        return stateInfo;
    }



    public static ContestEnums stateOf(int index){
        for (ContestEnums state:
                values() ) {
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
