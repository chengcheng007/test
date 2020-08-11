package com.example.demo6.sys.service.impl;

import com.example.demo6.sys.entity.VoteName;
import com.example.demo6.sys.entity.VoteRecordMemory;
import com.example.demo6.sys.mapper.VoteNameMapper;
import com.example.demo6.sys.service.VoteNameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class VoteNameServiceImpl extends ServiceImpl<VoteNameMapper, VoteName> implements VoteNameService {
    public List<VoteName> selectList(){
        List<VoteName> voteNames = baseMapper.selectList(null);
        return voteNames;
    }

    public List<Map<String, Object>> selectMaps(){
        List<Map<String, Object>> maps = baseMapper.selectMaps(null);
        return maps;
    }

    public List<VoteName> selectByMap(){
        List<VoteName> maps = baseMapper.selectByMap(null);
        return maps;
    }

    public List<VoteRecordMemory> selectByName(String name){
        List<VoteRecordMemory> voteRecordMemories = baseMapper.selectByName(name);
        return voteRecordMemories;
    }
}
