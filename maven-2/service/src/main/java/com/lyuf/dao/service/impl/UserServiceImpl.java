package com.lyuf.dao.service.impl;

import com.lyuf.dao.User;
import com.lyuf.dao.impl.UserDaoImpl;
import com.lyuf.dao.service.UserService;

import java.util.List;

/**
 * @author lyuf
 * @date 2020/9/22 12:32
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }
}
