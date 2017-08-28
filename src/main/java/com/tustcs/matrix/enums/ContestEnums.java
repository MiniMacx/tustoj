package com.tustcs.matrix.enums;

/**
 * Created by polykickshaw on 17-8-28.
 */
public enum  ContestEnums {
    SUCCESS(1,"成功"),

    END(0,"比赛已结束"),

    MD5_FAILED(-2,"MD5验证失败"),

    NOT_ENROLLED(-3,"未报名"),

    SYSTEM_ERROR(-1,"系统异常");



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
