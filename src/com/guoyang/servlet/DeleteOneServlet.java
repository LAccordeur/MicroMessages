package com.guoyang.servlet;

import com.guoyang.bean.Message;
import com.guoyang.sevice.CommandService;
import com.guoyang.sevice.MaintainService;
import com.guoyang.sevice.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by L'Accordeur on 2016/10/14.
 */
public class DeleteOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //接收页面参数
        String id = req.getParameter("id");
        CommandService commandService = new CommandService();
        commandService.deleteOne(id);

        req.getRequestDispatcher("/list.action").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
