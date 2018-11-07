package com.pc.aop.test;

import com.pc.aop.service.ProductService;
import com.pc.aop.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by switch on 16/10/1.
 */
public class AppTest {
    UserService userService = null;
    ApplicationContext context = null;
    ProductService productService = null;

    // 初始化
    @Before
    public void init() {
        String resource = "application-context.xml";
        context = new ClassPathXmlApplicationContext(resource);
        userService = context.getBean("userService", UserService.class);
        productService = context.getBean("productService", ProductService.class);
    }

    // 测试用户服务的Select方法
    @Test
    public void test_user_service_select() {
        String sql = "select * from user";
        // 为使之不抛出异常，catch它
        try {
            userService.select(sql);
        } catch (Exception e) {
            // nothing
        }
    }

    // 测试用户服务的insert方法
    @Test
    public void test_user_service_insert() {
        String sql = "insert into user value(null,?,?)";
        String param1 = "zs";
        String param2 = "123456";
        userService.insert(sql, param1, param2);
    }

    // 测试用户服务的update方法
    @Test
    public void test_product_service_update() {
        String sql = "update product set price=?";
        String param1 = "50";
        // 为使之不抛出异常，catch它
        try {
            productService.update(sql, param1);
        } catch (Exception e) {
            // nothing
        }
    }

    // 测试用户服务的delete方法
    @Test
    public void test_product_service_delete() {
        String sql = "delete from product where name=?";
        String param1 = "food";
        productService.delete(sql, param1);
    }


    // 销毁
    @After
    public void destory() {
        // 关闭context
        if (context != null) {
            ((ConfigurableApplicationContext) context).close();
        }
    }
}
