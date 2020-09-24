package com.lyuf.web;

import com.lyuf.dao.service.UserService;
import com.lyuf.dao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lyuf
 * @date 2020/9/22 12:38
 */
//@WebServlet("/User/findAll")
public class UserController extends HttpServlet {
    private UserService userService =  new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(userService.findAll());
    }
}
