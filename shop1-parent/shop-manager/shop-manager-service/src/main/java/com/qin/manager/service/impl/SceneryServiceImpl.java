package com.qin.manager.service.impl;

import com.qin.common.dto.Page;
import com.qin.common.dto.SceneryResult;
import com.qin.manager.model.vo.SceneryCustom;
import com.qin.manager.model.vo.SceneryQuery;
import com.qin.manager.service.SceneryService;
import com.qin.shop.manager.dao.SceneryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class SceneryServiceImpl implements SceneryService {

    //初始化日志:Logger
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入dao层接口
    @Autowired
    private SceneryMapper mapper;

    @Override
    public SceneryResult<SceneryCustom> listItemByPage(Page page, SceneryQuery query) {
        SceneryResult<SceneryCustom> result = new SceneryResult<>();
        result.setCode(0);
        result.setMsg("success");
        try {
            long count = mapper.customScenery(query);
            List<SceneryCustom> list = mapper.listSceneryByPage(page, query);
            result.setCount(count);
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("failed");
            result.setCode(1);
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public int insert(SceneryCustom sceneryCustom) {

        int i=0;
        try {
            i = mapper.insert(sceneryCustom);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return i;
    }

    @Override
    public int updateByIds(SceneryCustom sceneryCustom) {

        int i = 0;
        try {
            i = mapper.updateByIds(sceneryCustom);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }

        return i;
    }

    @Override
    public int updateBySid(SceneryCustom sceneryCustom) {

        int i=0;
        try {
            i = mapper.updateBySid(sceneryCustom);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return i;
    }

    @Override
    public SceneryCustom selectBySid(SceneryCustom sceneryCustom) {

        try {
            sceneryCustom=mapper.selectBySid(sceneryCustom);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }

        return sceneryCustom;
    }


}
