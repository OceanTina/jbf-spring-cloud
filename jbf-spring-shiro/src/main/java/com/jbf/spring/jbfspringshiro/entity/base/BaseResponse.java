package com.jbf.spring.jbfspringshiro.entity.base;

import com.jbf.spring.jbfspringshiro.enumeration.ResultEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse<T> {

    private int code;
    private String msg;
    private T data;

    public BaseResponse(){}

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造默认响应成功对象
     * @return
     */
    public static BaseResponse defaultSuccess() {
        BaseResponse response = new BaseResponse(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
        return response;
    }

    /**
     * 构造默认参数错误响应对象
     * @return
     */
    public static BaseResponse defaultBadRequest() {
        BaseResponse response = new BaseResponse(ResultEnum.REQUEST_PARAM_ERROR.getCode(), ResultEnum.REQUEST_PARAM_ERROR.getMsg());
        return response;
    }

    /**
     * 构造操作执行失败对象
     * @return
     */
    public static BaseResponse defaultFailure() {
        BaseResponse response = new BaseResponse(ResultEnum.INTERNAL_ERROR.getCode(), ResultEnum.INTERNAL_ERROR.getMsg());
        return response;
    }
}
