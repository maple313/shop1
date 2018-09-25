/*
package com.qin.shop.manager.dao;

import com.qin.manager.model.vo.SceneryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


*//** @Author: WZB
 * @Date: 2018/8/30 22:16
 * @Description:*//*




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ItemCustomMapperTest {

    @Autowired
    private SceneryMapper mapper;

    @Test
    public void updateByIds() {
        List<Integer> ids=new ArrayList<>();
        SceneryCustom itemCustem=new SceneryCustom();
        ids.add(1);
        ids.add(2);
        itemCustem.setIds(ids);
        int i=mapper.updateByIds(itemCustem);
       System.out.println(i);
    }

    @Test
    public void insert(){

        SceneryCustom itemCustem=new SceneryCustom();

        itemCustem.setSstatus(0);
        itemCustem.setScid(0);
        itemCustem.setSname("庐山");
        itemCustem.setSlocation("九江");
        itemCustem.setSprice(180);
        int i=mapper.insert(itemCustem);
        System.out.println(i);
    }

    @Test
    public void updateBySid(){

        SceneryCustom itemCustem=new SceneryCustom();
        itemCustem.setSid(13);
        itemCustem.setScid(0);
        itemCustem.setSprice(250);
        itemCustem.setSname("庐山");
        itemCustem.setSlocation("九江");
        itemCustem.setSstatus(0);

        int i=mapper.updateBySid(itemCustem);
    }

    @Test
    public void selectBySid(){
        SceneryCustom itemCustem=new SceneryCustom();
        itemCustem.setSid(1);
        System.out.println(itemCustem.getSid());
        itemCustem=mapper.selectBySid(itemCustem);
        System.out.println(itemCustem.getSname());
    }

}*/

