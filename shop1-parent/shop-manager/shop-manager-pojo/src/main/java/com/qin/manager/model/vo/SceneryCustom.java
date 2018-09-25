package com.qin.manager.model.vo;


import java.util.List;

/**
 * @Author: WZB
 * @Date: 2018/8/30 16:17
 * @Description: 连接查询的结果封装
 */
public class SceneryCustom extends Scenery {

    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    private List<Integer> ids;


    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }


}
