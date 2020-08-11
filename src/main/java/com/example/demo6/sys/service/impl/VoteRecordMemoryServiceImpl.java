package com.example.demo6.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import java.util.ArrayList;
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
        Map<Integer, String> NameHashMap = new HashMap<Integer, String>();
        Map<Integer, String> NameTrueHashMap = new HashMap<Integer, String>();
        for (Object object:voteNames){ //可以理解为 二维遍历
            VoteName v = (VoteName) object;  //一维数组 转对象
            NameHashMap.put(v.getId(),v.getName()); //通过对象 拿到对应的值 赋给map
            NameTrueHashMap.put(v.getId(),v.getNameTrue());
        }
        // integerStringHashMap.put(1, "一级管理员");
        // integerStringHashMap.put(2, "二级管理员");
        for (Object object:records){
            VoteRecordMemory voteRecordMemory = (VoteRecordMemory) object;
            voteRecordMemory.setGroupName(NameHashMap.get(voteRecordMemory.getGroupId()));
            voteRecordMemory.setGroupNameTrue(NameTrueHashMap.get(voteRecordMemory.getGroupId()));
        }
        return voteRecordMemoryIPage.getRecords();
    }

    public List selectList(){
        QueryWrapper queryWrapper2 = new QueryWrapper();
        queryWrapper2.between("id",1,1000);
        List<VoteRecordMemory> list1 = baseMapper.selectList(queryWrapper2);
        ArrayList arrayList = new ArrayList();
        for (Object o:list1){
            VoteRecordMemory v = (VoteRecordMemory) o;
            arrayList.add(v.getId());
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("id",arrayList);
        List list = baseMapper.selectList(queryWrapper);
        return list;
    }


}
