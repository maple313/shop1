package com.qin.manager.model.vo;

import java.io.Serializable;

/**
 * @Author: WZB
 * @Date: 2018/9/4 12:26
 * @Description:
 */
public class Scenery implements Serializable {

    private Integer sid;
    private String sname;
    private Integer sprice;
    private String sphone;
    private String straffic;
    private Integer scid;
    private String slocation;
    private String scontent;
    private Integer sstatus;
    private String sdescribe;

    public String getSdescribe() {
        return sdescribe;
    }

    public void setSdescribe(String sdescribe) {
        this.sdescribe = sdescribe;
    }

    public String getSlocation() {
        return slocation;
    }

    public void setSlocation(String slocation) {
        this.slocation = slocation;
    }

    public Integer getSstatus() {
        return sstatus;
    }

    public void setSstatus(Integer sstatus) {
        this.sstatus = sstatus;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSprice() {
        return sprice;
    }

    public void setSprice(Integer sprice) {
        this.sprice = sprice;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getStraffic() {
        return straffic;
    }

    public void setStraffic(String straffic) {
        this.straffic = straffic;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent;
    }
}
