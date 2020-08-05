package com.cheng.system.controller;

import com.cheng.system.mapper.UserDao;
import com.cheng.system.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        return "1";
    }

    @PostMapping("add")
    @ResponseBody
    public Object add(@RequestBody  UserModel userModel){
        int insert = userDao.insert(userModel);
        return insert;

    }

}
