package com.lyuf.dao.impl;

import com.lyuf.dao.User;
import com.lyuf.dao.UserDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyuf
 * @date 2020/9/22 11:36
 */
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() {
        return Arrays.asList(new User("aa", 12),
                new User("BB", 13),
        new User("CC", 14),
        new User("DD", 15)
        );
    }

}
