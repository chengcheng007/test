package com.example.demo6.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo6.common.page.PageRequest;
import com.example.demo6.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 成成
 * @since 2020-08-03
 */
public interface UserService extends IService<User> {

    public int deleteById(Serializable id);

    public IPage<User> selectPage(PageRequest pageRequest);
}
