package com.example.demo6;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo6.sys.entity.User;
import com.example.demo6.sys.entity.VoteRecordMemory;
import com.example.demo6.sys.mapper.UserMapper;
import com.example.demo6.sys.service.UserService;
import com.example.demo6.sys.service.VoteNameService;
import com.example.demo6.sys.service.VoteRecordMemoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.xml.ws.Action;
import java.util.*;


@EnableAsync
@SpringBootTest
class Demo6ApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    VoteRecordMemoryService voteRecordMemoryService;

    @Autowired
    VoteNameService voteNameService;

    @Test
    void test1(){
        Map<Integer, String> integerStringHashMap = new HashMap<Integer, String>();
        integerStringHashMap.put(1, "一级管理员");
        integerStringHashMap.put(2, "二级管理员");
        String s = integerStringHashMap.get(1);
        System.out.println(s);
    }

    @Test
    void test02(){
        List list = voteRecordMemoryService.selectList();
        System.out.println(list);
    }

    @Test
    void test03(){
        List<VoteRecordMemory> res = voteNameService.selectByName("一级管理员");
        System.out.println(res);
    }

    @Test
    void test01(){
        List<VoteRecordMemory> voteRecordMemories = voteRecordMemoryService.selectPage(1, 10);
        System.out.println(voteRecordMemories);
    }

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
        int i = userService.deleteById(1290211165164855298L);
        System.out.println(i);
    }

    @Test
    @Async
    void test5(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("chengcheng");
    }

}
