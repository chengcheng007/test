package com.example.demo6.sys.mapper;

import com.example.demo6.sys.entity.VoteName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo6.sys.entity.VoteRecordMemory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 成成
 * @since 2020-08-07
 */
public interface VoteNameMapper extends BaseMapper<VoteName> {
    /**
     * 和Mybatis使用方法一致
     * @param name
     * @return
     */
    List<VoteRecordMemory> selectByName(@Param("name") String name);
}
