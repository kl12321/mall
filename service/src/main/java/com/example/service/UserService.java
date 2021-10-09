package com.example.service;

import com.example.vo.ResultVo;

public interface UserService {
    ResultVo login( String name, String pwd);
    ResultVo register(String name,String pwd);
}
