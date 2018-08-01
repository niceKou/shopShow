package com.niceKou.module.controller;

import com.niceKou.module.dao.DemoDao;
import com.niceKou.module.domain.Demo;
import com.niceKou.module.domain.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class DemoController {
    private Logger logger = LoggerFactory.getLogger(DemoController.class);//.getLogger("com.niceKou");

    @Autowired
    private DemoDao userDao;

    // @RequestBody：接受json数据并转换成pojo对象
    // @ResponseBody：响应json数据，把pojo对象转换成json数据并响应

    /**
     * @param user ： 用户信息
     * @return user
     */
    @RequestMapping(value = "/addUser", produces = {"application/x-www-form-urlencoded; charset=UTF-8"})
    @ResponseBody
    public ResultBean<Demo> addUser(@RequestBody Demo user) {
        logger.info("西爱爱爱 addUser user: {}",user.toString());
        System.out.println("System addUser user: " + user.toString());
        logger.info("西爱爱爱  addUser user: " + user.toString());
        Integer userId = userDao.addUser(user);
        user.setUserId(userId);
        return ResultBean.createSuccessMsg(user);
    }

    @RequestMapping(value ="/{userId}")
    @ResponseBody
    public ResultBean<Demo> getUserById(@PathVariable("userId") String userId) {
        logger.info("getUserById userId: {}",userId);
        return ResultBean.createSuccessMsg(userDao.getUserById(Integer.valueOf(userId)));
    }

    @RequestMapping(value ="/listAll")
    @ResponseBody
    public ResultBean<List<Demo>> listAll() {
        return ResultBean.createSuccessMsg(userDao.listAllUser());
    }

    @RequestMapping(value ="/deleteUser/{userId}")
    @ResponseBody
    public ResultBean<Integer> deleteUser(@PathVariable("userId") String userId) {
        logger.info("deleteUser userId: {}",userId);
        return ResultBean.createSuccessMsg(userDao.deleteUser(Integer.valueOf(userId)));
    }
}
