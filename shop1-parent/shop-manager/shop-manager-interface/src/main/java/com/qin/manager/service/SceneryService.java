package com.qin.manager.service;


import com.qin.common.dto.Page;
import com.qin.common.dto.SceneryResult;
import com.qin.manager.model.vo.SceneryQuery;
import com.qin.manager.model.vo.SceneryCustom;
import org.apache.activemq.kaha.impl.data.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SceneryService {

    SceneryResult<SceneryCustom> listItemByPage(Page page, SceneryQuery query);

    int insert(SceneryCustom sceneryCustom);

    int updateByIds(SceneryCustom sceneryCustom);

    int updateBySid(SceneryCustom sceneryCustom);

    //根据主键来查询景点
    SceneryCustom selectBySid(SceneryCustom sceneryCustom);
    /*List<SceneryCustom> selectOrderBYName();*/
}
