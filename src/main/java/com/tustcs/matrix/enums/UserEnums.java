package com.tustcs.matrix.enums;

/**
 * Created by polykickshaw on 17-8-28.
 */
public enum  UserEnums {
    ADMINISTRATOR(10),
    SCHOOLLEADER(20),
    TEACHER(30),
    STUDENT(40);

    private int value;

    UserEnums(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
