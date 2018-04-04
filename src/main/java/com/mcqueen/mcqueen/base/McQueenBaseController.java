package com.mcqueen.mcqueen.base;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gfl on 2018/4/4 15:33
 * Email:gfl@cheok.com.
 */
public abstract class McQueenBaseController<T> {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public XaResult<T> handleUncaughtException(Exception exception) {
        return new XaResult("网络超时,请重试!");
    }


    @ExceptionHandler(McQueenException.class)
    public @ResponseBody XaResult<T> handleBusinessException(McQueenException mcQueenException) { // 业务逻辑异常
        return new XaResult<T>(mcQueenException.getMessage() == null ? "请检查网络" : mcQueenException.getMessage());
    }

}
