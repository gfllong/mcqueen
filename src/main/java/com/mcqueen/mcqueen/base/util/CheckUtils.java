package com.mcqueen.mcqueen.base.util;

import com.mcqueen.mcqueen.base.McQueenException;

/**
 * Created by gfl on 2018/4/4 15:50
 * Email:gfl@cheok.com.
 */
public class CheckUtils {

    public static void checkStatus(boolean status, String message) throws McQueenException {
        if (status)
            throw new McQueenException(message);
    }

}
