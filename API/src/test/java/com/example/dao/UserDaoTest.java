package com.example.dao;

import com.example.ApiApplication;
import com.example.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class UserDaoTest {

    @Resource
    UserDao dao;
    @Test
    public void queryUserByName() {
        User user = dao.queryUserByName("zhangsan");
        System.out.println(user);
    }
}