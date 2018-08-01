package com.niceKou.module.dao.impl;

import com.niceKou.module.dao.DemoDao;
import com.niceKou.module.domain.Demo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DemoDaoImpl implements DemoDao {
    private static final Logger logger = LogManager.getLogger();
    private Map<String, Demo> cacheMap = new HashMap<String, Demo>();
    private int index = 1;

    public Integer addUser(Demo user) {
        Integer userId = index;
        index++;
        user.setUserId(userId);
        cacheMap.put(userId+ "", user);
        return userId;
    }

    public Demo getUserById(Integer userId) {
        logger.info("getUserById: " + cacheMap);
        Demo user = cacheMap.get(userId.toString());
        return user;
    }

    public List<Demo> listAllUser() {
        List<Demo> userList = new ArrayList<Demo>();
        for (Map.Entry<String, Demo> entry : cacheMap.entrySet()) {
            Demo user = entry.getValue();
            userList.add(user);
        }
        return userList;
    }

    public Integer deleteUser(Integer userId) {
        Demo user = cacheMap.remove(userId.toString());
        return user == null ? 0: 1;
    }
}
