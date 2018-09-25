package com.qin.shop.manager.dao;

import com.qin.common.jedis.JedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

 /* @Author: WZB
 * @Date: 2018/9/10 19:50
 * @Description:
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-jedis.xml")
public class JedisTest {

    @Autowired
    private JedisClient client;

    @Test
    public void test1(){

        System.out.println(client.get("name"));
    }

    @Test
    public void test2() throws IOException {

        Set<HostAndPort> nodes=new HashSet<>();
        //添加集合元素
        nodes.add(new HostAndPort("47.99.74.228",7001));
        nodes.add(new HostAndPort("47.99.74.228",7002));
        nodes.add(new HostAndPort("47.99.74.228",7003));
        nodes.add(new HostAndPort("47.99.74.228",7004));
        nodes.add(new HostAndPort("47.99.74.228",7005));
        nodes.add(new HostAndPort("47.99.74.228",7006));
        //获取JedisPool配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        //获取jedis集群
        JedisCluster jedisCluster=new JedisCluster(nodes,300,300,20,"maple313",config);
        //取值
        System.out.println(jedisCluster.get("name"));
        //释放资源
        jedisCluster.close();

    }
}
