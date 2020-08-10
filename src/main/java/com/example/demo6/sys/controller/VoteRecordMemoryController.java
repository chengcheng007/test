package com.example.demo6.sys.controller;


import com.example.demo6.common.result.CommonResult;
import com.example.demo6.sys.entity.VoteRecordMemory;
import com.example.demo6.sys.service.VoteRecordMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 成成
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/sys/vote-record-memory")
public class VoteRecordMemoryController {
    @Autowired
    VoteRecordMemoryService voteRecordMemoryService;

    @GetMapping("/getMemoryPage/{page}/{size}")
    public CommonResult<List<VoteRecordMemory>> getMemoryPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        List<VoteRecordMemory> voteRecordMemories = voteRecordMemoryService.selectPage(page, size);
        return CommonResult.success(voteRecordMemories);
    }
}

