package com.pc.aop.service;

import org.springframework.stereotype.Component;

/**
 * 用户服务类
 * Created by switch on 16/10/1.
 */
@Component("userService")
public class UserService {
    public void select(String sql) {
        System.out.println("查询语句为：" + sql);
        throw new RuntimeException();
    }

    public void insert(String sql, String param1, String param2) {
        System.out.println("插入语句为：" + sql + "  参数1为：" + param1 + "  参数2为：" + param2);
    }
}
