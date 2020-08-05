package com.cheng.system.controller;

import com.cheng.system.mapper.OrgDao;
import com.cheng.system.model.OrgModel;
import com.cheng.system.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2020-06-08
 */
@RestController
@RequestMapping("org")
public class OrgController {
    @Autowired
    OrgDao orgDao;

    @PostMapping("add")
    @ResponseBody
    public Object add(@RequestBody OrgModel orgModel){
        int insert = orgDao.insert(orgModel);
        return insert;

    }
}
