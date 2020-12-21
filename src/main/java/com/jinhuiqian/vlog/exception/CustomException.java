package com.jinhuiqian.vlog.exception;

import com.jinhuiqian.vlog.common.ResultCode;

/**
 * @author 231
 * @date 2020-12-19 19:50
 */
public class CustomException extends RuntimeException{
    protected ResultCode resultCode;

    public CustomException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
