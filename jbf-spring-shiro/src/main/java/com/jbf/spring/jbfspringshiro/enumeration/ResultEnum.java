package com.jbf.spring.jbfspringshiro.enumeration;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0, "success"),

    INTERNAL_ERROR(10099, "系统内部错误"),

    LOGIN_ERROR(10001, "未登录"),
    LOGIN_ERROR_TOKEN(10002, "Token无效"),
    LOGIN_TOKEN_EXPIRE(10003, "Token过期"),
    LOGIN_ERROR_USERNAME(10004, "用户名不存在"),
    LOGIN_ERROR_VALIDATE(10005, "密码错误"),

    REQUEST_PARAM_ERROR(10010, "参数错误"),
    REQUEST_PARAM_NO_CONTENT_TYPE(10011, "请求头缺少content-type"),
    REQUEST_ERROR_SIGN(10012, "签名错误"),

    RESPONSE_ENCRYPT_ERROR(10020, "返回参数加密错误"),

    DATA_REPEATED_RECORD(10030,"重复数据"),
    DATA_ADD_ERROR(10031,"数据添加失败"),

    TASK_CANNOT_RECEIVE(10040, "领取失败，该任务无法被领取"),
    TASK_RECEIVE_OVER_TOP(10041, "领取失败，任务合并已达上限"),
    TASK_MERGED_SUCCESS(10042, "领取成功，任务已合并"),
    TASK_MERGED_FAILED(10043, "领取失败，任务合并失败"),
    USER_TASK_DIFFERENT_PROVINCE(10044, "领取失败，该任务不在用户所在的省份"),
    TASK_NOT_EXIST(10045, "任务不存在"),


    TASK_NOT_FINISHED(10050, "提交失败，任务未完成"),
    DELETE_TASK_FAILED(10051, "删除失败"),
    CHECK_TASK_FAILED(10052, "验收失败"),
    SETTLEMENT_TASK_FAILED(10053, "结算失败"),
    PUBLISH_TASK_FAILED(10054, "发布失败");

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;
}
