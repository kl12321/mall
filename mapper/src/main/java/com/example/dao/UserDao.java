package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User queryUserByName(String name);
    int insertUser(User user);
}
