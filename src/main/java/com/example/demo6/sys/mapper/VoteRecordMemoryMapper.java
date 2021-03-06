package com.example.demo6.sys.mapper;

import com.example.demo6.sys.entity.VoteRecordMemory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 成成
 * @since 2020-08-07
 */
public interface VoteRecordMemoryMapper extends BaseMapper<VoteRecordMemory> {

    void  CreateMemoryID();

    void  InsertMemoryID();

    List<VoteRecordMemoryMapper> SelectMemoryID();

    List<VoteRecordMemoryMapper> SelectRelationMemory();

}
