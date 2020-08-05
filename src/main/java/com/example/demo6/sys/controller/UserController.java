package com.example.demo6.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo6.common.page.PageRequest;
import com.example.demo6.common.result.CommonResult;
import com.example.demo6.sys.entity.User;
import com.example.demo6.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 成成
 * @since 2020-08-03
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("getUserPage")
    public CommonResult getUserPage(PageRequest pageRequest){
        return CommonResult.success(userService.selectPage(pageRequest));
    }

    @GetMapping("/getUserAll")
    public CommonResult getUserAll(){
        //QueryWrapper queryWrapper = new QueryWrapper(); //条件构造器
        return CommonResult.success(userService.list());
    }

    @GetMapping("/getUser/{id}") //1290183450713964545
    public CommonResult getUser(@PathVariable("id") Long id){
        return CommonResult.success(userService.getById(id));
    }

    @PostMapping("/saveUser")
    public CommonResult saveUser(User user){
        boolean save = userService.save(user);
        if (save == true){
            return CommonResult.success("添加成功");
        }
        return CommonResult.error("添加失败");
    }

    @PutMapping("/updateUser")
    public CommonResult updateUser(User user){
        User userBy = userService.getById(user);
        boolean update = userService.updateById(userBy);
        if (update == true){
            return CommonResult.success("修改成功");
        }
        return CommonResult.error("修改失败");
    }

    @DeleteMapping("/deleteUser/{id}")
    public CommonResult deleteUser(@PathVariable("id") Long id){
        int i = userService.deleteById(id);
        if (i == 1){
            return CommonResult.success("删除成功");
        }
        return CommonResult.error("删除失败");
    }
}

