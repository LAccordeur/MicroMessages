package com.guoyang.servlet;

import com.guoyang.bean.Command;
import com.guoyang.bean.Message;
import com.guoyang.sevice.CommandService;
import com.guoyang.sevice.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/13.
 */
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");

        //接收页面参数
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        //向页面传值
        req.setAttribute("command",command);
        req.setAttribute("description",description);
        Command commandBean = new Command();
        commandBean.setName(command);
        commandBean.setDescription(description);


        CommandService commandService = new CommandService();
        List<Command> commands = commandService.queryCommandList(commandBean);
        req.setAttribute("commandList",commands);
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
