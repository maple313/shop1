package com.qin.manager.model.vo;

import java.io.Serializable;

/**
 * @Author: WZB
 * @Date: 2018/9/4 17:10
 * @Description:
 */
public class City implements Serializable {

    private Integer cid;
    private String cname;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
