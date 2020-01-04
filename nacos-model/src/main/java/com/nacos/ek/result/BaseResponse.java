/*
 * @(#)com.cloud.food.controller 2020-01-04 11:41
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.nacos.ek.result;

import lombok.Data;

import java.io.Serializable;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in 2020-01-04 14:06
 * @Title BaseResponse.java
 * <p>Description: [ 统一返回 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc: FreeBrio </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Data
public class BaseResponse implements Serializable {

    public static final String SUCCESS_CODE = "000000"; // 请求成功code
    public static final String SUCCESS_CODE_MSG = "操作成功";//请求成功mes
    public static final String ERROR_CODE = "999999";//系统错误 code
    public static final String ERROR_CODE_MSG = "系统错误";//系统错误 mes
    public static final String ERROR_REQ_FAIL_CODE = "999998";//请求失败 code
    public static final String ERROR_REQ_FAIL_MSG = "请求失败";//请求失败 mes
    public static final String ERROR_PDP_CODE = "999997";//业务抛出异常 code
    public static final String ERROR_PDP_CODE_MSG = "业务抛出异常";//业务抛出异常 mes
    public static final String ERROR_NO_PERM_CODE = "000001";
    public static final String ERROR_NO_PERM_CODE_MSG = "无权限访问";
    public static final String ERROR_NO_TOKEN_CODE = "000002";
    public static final String ERROR_NO_TOKEN_MSG = "登录失效！请重新登录";
    /**
     * 未知异常
     */
    public static final int UNKNOWN_EXCEPTION = -99;
    /**
     * @Fields serialVersionUID : TODO[ 用一句话描述这个变量表示什么 ]
     */
    private static final long serialVersionUID = 7431264204510322466L;
    /**
     * @Fields code : TODO[响应编码 ]
     */
    private Object code;
    /**
     * @Fields message : TODO[响应信息 ]
     */
    private Object message;
    /**
     * 返回的数据
     */
    private Object data;

    private BaseResponse(Object code, Object message) {
        this.code = code;
        this.message = message;
    }

    private BaseResponse(Object code, Object message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse success(Object data) {
        return new BaseResponse(SUCCESS_CODE, SUCCESS_CODE_MSG, data);
    }

    public static BaseResponse success() {
        return new BaseResponse(SUCCESS_CODE, SUCCESS_CODE_MSG);
    }

    public static BaseResponse success(String message, Object data) {
        return new BaseResponse(SUCCESS_CODE, message, data);
    }

    public static BaseResponse error(String message, Object vo) {
        return new BaseResponse(ERROR_CODE, message, vo);
    }

    public static BaseResponse error() {
        return new BaseResponse(ERROR_CODE, ERROR_CODE_MSG);
    }

    public static BaseResponse errorNoPerm() {
        return new BaseResponse(ERROR_NO_PERM_CODE, ERROR_NO_PERM_CODE_MSG);

    }

    public static BaseResponse errorNoToken() {
        return new BaseResponse(ERROR_NO_TOKEN_CODE, ERROR_NO_TOKEN_MSG);
    }

    public static BaseResponse error(String message) {
        return new BaseResponse(ERROR_CODE, message);
    }

    public BaseResponse format(String message) {
        this.message = message;
        return this;
    }
}
