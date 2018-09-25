package com.qin.manager.service.impl;

import com.qin.manager.model.vo.SceneryIndex;
import com.qin.manager.service.ISceneryIndex;
import com.qin.shop.manager.dao.SceneryIndexMapper;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: WZB
 * @Date: 2018/9/14 11:02
 * @Description:
 */
@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class SceneryIndexImpl implements ISceneryIndex {

    //初始化日志:Logger
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SceneryIndexMapper mapper;

    @Autowired
    private SolrServer solrServer;

    @Override
    public void importIndex() {

        try {
            //1 采集数据,注入dao层接口
            List<SceneryIndex> list=mapper.listIndex();
            //2 遍历数据集产生documentList，注入solrServer
            for (SceneryIndex sceneryIndex :list) {
                //创建一个文档
                SolrInputDocument document=new SolrInputDocument();
                //逐个添加字段到文档中
                document.addField("id", sceneryIndex.getSid());
                document.addField("sname", sceneryIndex.getSname());
                document.addField("sprice", sceneryIndex.getSprice());
                document.addField("straffic", sceneryIndex.getStraffic());
                document.addField("slocation", sceneryIndex.getSlocation());
                document.addField("scontent", sceneryIndex.getScontent());
                document.addField("cname", sceneryIndex.getCname());
                //添加到索引库
                solrServer.add(document);
            }
            //3 提交，注入solrServer
            solrServer.commit();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }


    }
}
