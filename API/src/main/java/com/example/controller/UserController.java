package com.example.controller;

import com.example.service.UserService;
import com.example.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(value = "用户模块",tags = "用户管理")
public class UserController {
    @Resource
    private UserService service;

    @ApiImplicitParams({@ApiImplicitParam(dataType = "string",name="username",value = "用户登录账号",required = true)
    })@ApiImplicitParam(dataType = "string",name="password",value = "用户登录密码",required = true)
    @ApiOperation("用户登录接口")
    @GetMapping("/login")
    public ResultVo login(@RequestParam("username") String username,
                          @RequestParam(value = "password",defaultValue = "1111") String password){
        ResultVo result=service.login(username,password);
        return result;
    }



    @ApiOperation("用户注册接口")
    @ApiImplicitParams({@ApiImplicitParam(dataType = "string",name="username",value = "用户登录账号",required = true)
    })@ApiImplicitParam(dataType = "string",name="password",value = "用户登录密码",required = true)
    @PostMapping("/register")
    public ResultVo register(String username,String password){
        ResultVo result =service.register(username, password);
        return result;
    }



}
