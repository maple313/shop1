package com.qin.manager.web;

import com.alibaba.druid.util.StringUtils;
import com.qin.common.core.JsonUtils;
import com.qin.common.core.PropKit;
import com.qin.common.core.StrKit;
import com.qin.common.dto.Page;
import com.qin.common.dto.SceneryIndexResult;
import com.qin.common.dto.SceneryResult;
import com.qin.common.fdfs.FastDFSFile;
import com.qin.common.fdfs.FastDFSUtils;
import com.qin.manager.model.vo.SceneryCustom;
import com.qin.manager.model.vo.SceneryQuery;
import com.qin.manager.service.ISceneryIndex;
import com.qin.manager.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.jms.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerSceneryAction {

    @Autowired
    private SceneryService ser;

    @Autowired
    private ISceneryIndex sceneryIndex;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination destination;

    @RequestMapping("/items")
    @ResponseBody
    public SceneryResult<SceneryCustom> listItemByPage(Page page, SceneryQuery query) {

        SceneryResult<SceneryCustom> result = null;

        result = ser.listItemByPage(page, query);
        return result;
    }

    //增加新景点
    @RequestMapping("/addScenery.do")
    @ResponseBody
    public Object addScenery(SceneryCustom sceneryCustom) {
        String sdescribe = sceneryCustom.getSdescribe();
        String[] str = sdescribe.split("\"");
        sdescribe = str[1];
        sceneryCustom.setSdescribe(sdescribe);
        sceneryCustom.setSstatus(0);
        sceneryCustom.setScid(0);
        int i = ser.insert(sceneryCustom);
        return i;
    }

    //逻辑删除
    @RequestMapping("/scenery/batch")
    @ResponseBody
    public Object updateByIds(@RequestParam("ids[]") List<Integer> ids) {

        SceneryCustom sceneryCustom = new SceneryCustom();
        sceneryCustom.setIds(ids);
        int i = 0;
        i = ser.updateByIds(sceneryCustom);
        return i;
    }

    //跳转到修改页面
    @RequestMapping("/toupdate.do")
    public String toupdate(SceneryCustom sceneryCustom, Model model) {
        int i = sceneryCustom.getSid();
        sceneryCustom = ser.selectBySid(sceneryCustom);
        model.addAttribute("scneryCustom", sceneryCustom);
        return "/pages/indexlib/update";
    }

    //修改
    @RequestMapping("/update.do")
    @ResponseBody()
    public Object updateScenery(SceneryCustom sceneryCustom) {
        int i = ser.updateBySid(sceneryCustom);
        return i;
    }

    //图片回显
    @RequestMapping("/uploadImage")
    @ResponseBody
    public Object uploadImage(@RequestParam MultipartFile file) {

        Map<String, Object> map = new HashMap<>();
        String jsonString = null;

        try {

            //1.获取fastdfsfile
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), file.getOriginalFilename(), file.getSize());

            //fdfs_server = http://47.99.74.228
            String basePath = PropKit.use("fdfs_client.conf").get("fdfs_server");

            //2调用fastdfsUtils的上传方法
            String filepath = FastDFSUtils.uploadFile(fastDFSFile);

            //判断filepath
            if (StrKit.notBlank(filepath)) {
                map.put("code", 0);
                map.put("msg", "success");
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("src", basePath + "/" + filepath);
                map.put("data", dataMap);
            } else {

                map.put("code", 1);
                map.put("msg", "failed");
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("src", "");
                map.put("data", dataMap);
            }
            //3.返回 json
            jsonString = JsonUtils.objectToJson(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    //一键导入索引库
    @RequestMapping("/scenery/indexlib/import")
    @ResponseBody
    public SceneryIndexResult importIndex() {

        SceneryIndexResult result = new SceneryIndexResult();
        result.setFlg(false);
        result.setMsg("failed");
        try {
            sceneryIndex.importIndex();
            result.setFlg(true);
            result.setMsg("success!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    //发布消息
    @RequestMapping("/publish")
    @ResponseBody
    public void saveScenery(){

        int sid=1;

        //发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(sid+"");
                return textMessage;
            }
        });
    }
}
