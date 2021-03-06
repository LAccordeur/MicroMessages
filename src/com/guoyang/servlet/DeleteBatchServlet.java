package com.guoyang.servlet;

import com.guoyang.bean.Message;
import com.guoyang.sevice.CommandService;
import com.guoyang.sevice.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by L'Accordeur on 2016/10/14.
 */
public class DeleteBatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //接收页面参数
        String[] ids = req.getParameterValues("id");
        CommandService commandService = new CommandService();
        if (ids != null) {
            commandService.deleteBatch(ids);
        }
        req.getRequestDispatcher("/list.action").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
