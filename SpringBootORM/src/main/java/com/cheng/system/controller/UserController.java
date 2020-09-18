package com.cheng.system.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.cheng.system.mapper.UserDao;
import com.cheng.system.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-02
 */
@RestController
@RequestMapping("sys")

public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("get")
    public Object getUser(){
        Map<String,Object> map = new HashMap();
        map.put("account","admin");
        map.put("password","123456");

        String s = JSONUtil.toJsonStr(map);
        HttpRequest post1 = HttpUtil.createPost("http://localhost:8080/api/v1/sso/login");
        post1.body(s);
        HttpResponse execute = post1.execute();
        String body = execute.body();
   //     String post = HttpUtil.post("http://127.0.0.1:8080/api/v1/sso/login", map);
        return body;
    }

    @PostMapping("add")
    @ResponseBody
    public Object add(@RequestBody  UserModel userModel){
        int insert = userDao.insert(userModel);
        return insert;

    }

}
