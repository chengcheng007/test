package com.example.demo6.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo6.sys.entity.VoteName;
import com.example.demo6.sys.entity.VoteRecordMemory;
import com.example.demo6.sys.mapper.VoteRecordMemoryMapper;
import com.example.demo6.sys.service.VoteNameService;
import com.example.demo6.sys.service.VoteRecordMemoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 成成
 * @since 2020-08-07
 */
@Service
public class VoteRecordMemoryServiceImpl extends ServiceImpl<VoteRecordMemoryMapper, VoteRecordMemory> implements VoteRecordMemoryService {

    @Autowired
    VoteNameService voteNameService;

    public List<VoteRecordMemory> selectPage(Integer page, Integer size){
        Page<VoteRecordMemory> objectPage = new Page<>(page,size);
        IPage<VoteRecordMemory> voteRecordMemoryIPage = baseMapper.selectPage(objectPage, null);
        List<VoteRecordMemory> records = voteRecordMemoryIPage.getRecords();

        List<VoteName> voteNames = voteNameService.selectList();
        Map<Integer, String> integerStringHashMap = new HashMap<Integer, String>();
        for (Object object:voteNames){
            VoteName v = (VoteName) object;
            integerStringHashMap.put(v.getId(),v.getName());
        }
        // integerStringHashMap.put(1, "一级管理员");
        // integerStringHashMap.put(2, "二级管理员");

        for (Object object:records){
            VoteRecordMemory voteRecordMemory = (VoteRecordMemory) object;
            String s = integerStringHashMap.get(voteRecordMemory.getGroupId());
            voteRecordMemory.setGroupName(s);
        }
        return voteRecordMemoryIPage.getRecords();
    }
}
