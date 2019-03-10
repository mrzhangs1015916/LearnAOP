package com.pc.aop.service;

import org.springframework.stereotype.Component;

/**
 * 产品服务类12dfg
 * Created by switch on 16/10/2.
 */
@Component("productService")
public class ProductService {
    public void update(String sql, String param) {
        System.out.println("更新语句为：" + sql + "  参数1为：" + param);
        throw new RuntimeException();
    }

    public void delete(String sql, String param1) {
        System.out.println("删除语句为：" + sql + "  参数1为：" + param1);
    }
}
