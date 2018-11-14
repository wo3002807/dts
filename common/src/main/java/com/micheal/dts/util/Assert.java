package com.micheal.dts.util;


import com.micheal.dts.exception.BusinessException;

public class Assert {
    public static void state(boolean expression, String expCode) {
        if (!expression) {
            throw new BusinessException(expCode);
        }
    }
    public static void isTrue(boolean expression, String expCode) {
        if (!expression) {
            throw new BusinessException(expCode);
        }
    }
    public static void isNull(Object object, String expCode) {
        if (object != null) {
            throw new BusinessException(expCode);
        }
    }
    public static void notNull(Object obj, String retCode) {
        if (obj == null) {
            throw new RuntimeException(retCode);
        }
    }

    public static void isEqual(int expect, int actual, String retCode) {
        if (expect != actual) {
            throw new RuntimeException(retCode);
        }
    }
}
