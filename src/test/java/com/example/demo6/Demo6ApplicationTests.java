package com.example.demo6;

import com.example.demo6.sys.entity.User;
import com.example.demo6.sys.mapper.UserMapper;
import com.example.demo6.sys.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo6ApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user =new User();
        user.setId(1290183450713964545L);
        user.setAge(20);
        user.setEmail("1027386974@qq.com");
        user.setName("chengcheng");
        boolean save = userService.updateById(user);
        System.out.println(save);
    }

    @Test
    void test2(){
        User user =new User();
        user.setAge(19);
        user.setEmail("1027386974@qq.com");
        user.setName("chengcheng");
        boolean save = userService.save(user);
        System.out.println(save);
    }

    @Test
    void test3(){
        User byId = userService.getById(1290183450713964545L);
        byId.setAge(20);
        boolean b = userService.updateById(byId);
        System.out.println(b);
    }

    @Test
    void test4(){
        int i = userService.deleteById(1290183450713964545L);
        System.out.println(i);
    }
}
