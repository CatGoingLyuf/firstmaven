package com.lyuf.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyuf.dao.UserDao;
import com.lyuf.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author lyuf
 * @date 2020/9/23 15:42
 */
public class MybatisTest {

    @Test
    public void testFindAll() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> users = userDao.findAll();

        System.out.println(users);

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindById() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User byId = userDao.findById(1);

        System.out.println(byId);

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testAddUser() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setName("ggg");

        mapper.addUser(user);
        System.out.println(user);
        sqlSession.commit();


        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testDeleteUser() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.deleteUser("10");

        sqlSession.commit();
        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testUpdateUser() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();

        user.setName("ddd");
        user.setId(4);

        mapper.updateUser(user);
        System.out.println(user);
        sqlSession.commit();

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindByName1() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> a = mapper.findByName1("a");

        System.out.println(a);

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindByName2() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> a = mapper.findByName2("%a%");

        System.out.println(a);


        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindByName3() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> a = mapper.findByName3("a");

        System.out.println(a);


        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testGetTotalCount() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        Integer totalCount = mapper.getTotalCount();

        System.out.println(totalCount);

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindByPageData() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        HashMap<String, Integer> map = new HashMap<>();

        map.put("num1",0);
        map.put("num2",2);

        List<User> byPageData = mapper.findByPageData(map);

        System.out.println(byPageData);

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public void testFindByPage() throws Exception {

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        PageHelper.startPage(0,2);

        List<User> all = mapper.findAll();

        PageInfo<User> userPageInfo = new PageInfo<>(all);

        System.out.println(userPageInfo);
        System.out.println(userPageInfo.getList());
        System.out.println(userPageInfo.getNavigateFirstPage());
        System.out.println(userPageInfo.getNavigateLastPage());

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

}
