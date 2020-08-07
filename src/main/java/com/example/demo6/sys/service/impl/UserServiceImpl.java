package com.example.demo6.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo6.common.page.PageRequest;
import com.example.demo6.sys.entity.User;
import com.example.demo6.sys.mapper.UserMapper;
import com.example.demo6.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 成成
 * @since 2020-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public int deleteById(Serializable id){
        int res = baseMapper.deleteById(id);
        return res;
    }

    @Override
    public IPage<User> selectPage(PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        Page<User> page = new Page<>(pageNum,pageSize);
        IPage<User> userIPage = baseMapper.selectPage(page, null);
        return userIPage;
    }

    @Override
    public String Async_CC(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("chengcheng");
        return "chengcheng";
    }
}
