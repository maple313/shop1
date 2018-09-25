package com.qin.manager.model.vo;

import java.io.Serializable;

/**
 * @Author: WZB
 * @Date: 2018/9/14 10:42
 * @Description: 索引封装
 */
public class SceneryIndex implements Serializable {

    private int sid;
    private String sname;
    private int sprice;
    private String straffic;
    private String slocation;
    private String scontent;
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSprice() {
        return sprice;
    }

    public void setSprice(int sprice) {
        this.sprice = sprice;
    }

    public String getStraffic() {
        return straffic;
    }

    public void setStraffic(String straffic) {
        this.straffic = straffic;
    }

    public String getSlocation() {
        return slocation;
    }

    public void setSlocation(String slocation) {
        this.slocation = slocation;
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent;
    }
}
