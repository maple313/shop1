package com.qin.manager.web;

import com.qin.manager.model.vo.SceneryCustom;
import com.qin.manager.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ManagerIndexAction {

    //织入
    @Autowired
    private SceneryService ser;

    //可以动态访问当前目录下的任一jsp
    @RequestMapping("/{page}")
    public String index1(@PathVariable String page, Model model) {

       /* List<SceneryCustom> typeList=ser.selectOrderBYName();
        model.addAttribute("typeList",typeList);*/
        return page;
    }


    //动态访问pages目录下的任一jsp页面
    @RequestMapping("/pages/{pageName}")
    public String index2(@PathVariable String pageName) {
        return "pages/" + pageName;
    }

    //动态访问pages目录下的任一文件夹后的任一jsp页面
    @RequestMapping(value = "/pages/{pageName1}/{pageName2}", method = RequestMethod.GET)
    public String index3(@PathVariable String pageName1, @PathVariable String pageName2) {
        return "pages/" + pageName1 + "/" + pageName2;
    }
}
