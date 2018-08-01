package com.niceKou.module.domain;

import com.niceKou.module.constant.ResultCodeEnum;

import java.io.Serializable;

/**
 *
 * 统一result类
 * @param <T>
 */
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = -6590380286406468993L;

    /**
     * 返回码： 00000000表示成功，其余表示失败（参照ResultCodeEnum）
     */
    private String code;

    /**
     * 错误描述
     */
    private String desc;

    /**
     * 返回数据
     */
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ResultBean(String code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public ResultBean(String code, T data) {
        this.code = code;
        this.desc = ResultCodeEnum.getNameByCode(code);
        this.data = data;
    }

    public static <T> ResultBean<T> createErrorMsg(String code, String desc, T data) {
        return new ResultBean<T>(code, desc, data);
    }

    public static <T> ResultBean<T> createErrorMsg(String code, T data) {
        return new ResultBean<T>(code, data);
    }


    public static <T> ResultBean<T> createSuccessMsg(T data) {
        return new ResultBean<T>(ResultCodeEnum.SUCCESS.getCode(), data);
    }

    public static <T> ResultBean<T> createSuccessMsg() {
        return new ResultBean<T>(ResultCodeEnum.SUCCESS.getCode(), null);
    }


    @Override
    public String toString() {
        return "ResultBean{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }
}
