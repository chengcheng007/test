package com.example.demo6.sys.service;

import com.example.demo6.sys.entity.VoteRecordMemory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 成成
 * @since 2020-08-07
 */
public interface VoteRecordMemoryService extends IService<VoteRecordMemory> {
    public List<VoteRecordMemory> selectPage(Integer page, Integer size);
}
