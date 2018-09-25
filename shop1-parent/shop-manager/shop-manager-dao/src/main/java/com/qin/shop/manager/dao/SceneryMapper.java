package com.qin.shop.manager.dao;

import com.qin.common.dto.Page;
import com.qin.manager.model.vo.SceneryCustom;
import com.qin.manager.model.vo.SceneryQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: WZB
 * @Date: 2018/9/4 12:33
 * @Description:
 */
public interface SceneryMapper {

    //1.查询所有的景点
    long customScenery(@Param("query") SceneryQuery query);

    //2.查询分页景点
    List<SceneryCustom> listSceneryByPage(@Param("page") Page page, @Param("query") SceneryQuery query);

    //3.修改景点内容
    int updateBySid(@Param("sceneryCustom")SceneryCustom sceneryCustom);

    //4.逻辑批量删除
    int updateByIds(@Param("sceneryCustom")SceneryCustom sceneryCustom);

    //5.添加景点
    int insert(@Param("sceneryCustom")SceneryCustom sceneryCustom);

    //6.根据主键来查询景点
    SceneryCustom selectBySid(@Param("sceneryCustom")SceneryCustom sceneryCustom);
}
