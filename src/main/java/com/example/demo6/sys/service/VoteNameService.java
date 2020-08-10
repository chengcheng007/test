package com.example.demo6.sys.service;

import com.example.demo6.sys.entity.VoteName;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 成成
 * @since 2020-08-07
 */
public interface VoteNameService extends IService<VoteName> {
    public List<VoteName> selectList();

    List<Map<String, Object>> selectMaps();

    public List<VoteName> selectByMap();
}
