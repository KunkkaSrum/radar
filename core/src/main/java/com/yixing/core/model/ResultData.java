package com.yixing.core.model;

import java.util.List;

public class ResultData {
    private long count;
    private int code;
    private String msg;
    private Object data;

    public ResultData() {
        super();
    }

    public ResultData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(long count, int code, String msg, Object data) {
        this.count = count;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "[{" +
                "count:" + count +
                ", code:" + code +
                ", msg:'" + msg + '\'' +
                ", data:" + data +
                "}]";
    }


}
