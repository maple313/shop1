package com.qin.common.dto;

import java.io.Serializable;

/**
 * @Author: WZB
 * @Date: 2018/9/14 9:20
 * @Description:
 */
public class SceneryIndexResult implements Serializable {

    private String msg;
    private Object data;
    private boolean flg;

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

    public boolean isFlg() {
        return flg;
    }

    public void setFlg(boolean flg) {
        this.flg = flg;
    }
}
