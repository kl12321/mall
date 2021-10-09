package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.MD5Utils;
import com.example.vo.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
   private UserDao dao;
    @Override
    public ResultVo login(String name, String pwd) {
        User user = dao.queryUserByName(name);

        if (user == null) {
            return  new ResultVo(0,"用户不存在",null);
        } else if (MD5Utils.md5(pwd).equals(user.getPassword())) {
            return  new ResultVo(1,"登录成功",user);

        }else{
            return  new ResultVo(0,"密码错误",null);
        }

    }
    @Transactional
    @Override
    public ResultVo register(String name, String pwd) {
        User user = dao.queryUserByName(name);
        if (user == null) {
            user = new User();
            user.setUsername(name);
            user.setPassword(MD5Utils.md5(pwd));
            user.setUserRegtime(new Date());
            user.setUserModtime(new Date());
            user.setUserImg("img/default.png");
            int result = dao.insertUser(user);
            if (result == 1) {
                return new ResultVo(1, "注册成功", user);
            } else {
                return new ResultVo(0, "注册失败", null);
            }
        }else{
            return new ResultVo(0,"用户名已存在",null);
        }
    }
}
