package com.jbf.spring.jbfspringshiro.service;

import com.jbf.spring.jbfspringshiro.entity.UserBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {

    public UserBean getUser(String username) {
        // 没有此用户直接返回null
//        if (! DataSource.getData().containsKey(username))
//            return null;

        UserBean user = new UserBean();
//        Map<String, String> detail = DataSource.getData().get(username);
        Map<String, String> detail = new HashMap<>();
        detail.put("password", "l123456");
        detail.put("role", "vip");
        detail.put("permission", "view,edit");

        user.setUsername(username);
        user.setPassword(detail.get("password"));
        user.setRole(detail.get("role"));
        user.setPermission(detail.get("permission"));
        return user;
    }
}
