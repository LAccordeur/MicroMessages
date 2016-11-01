package com.guoyang.servlet;

import com.guoyang.bean.Command;
import com.guoyang.bean.CommandContent;
import com.guoyang.sevice.CommandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/27.
 */
public class AddCommandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");
        //接收页面参数
        String type = req.getParameter("type");

        if ("jump".equals(type)) {
            req.getRequestDispatcher("/WEB-INF/jsp/back/addCommand.jsp").forward(req, resp);
        } else if ("add".equals(type)) {
            //获取页面参数
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String[] contents = req.getParameterValues("content");

            if (name != null && description != null && contents != null  && !"".equals(name) && !"".equals(description)) {
                //封装并传送数据
                CommandService commandService = new CommandService();
                List<CommandContent> commandContents = new ArrayList<CommandContent>();
                for (String content : contents) {
                    CommandContent commandContent = new CommandContent();
                    commandContent.setContent(content);
                    commandContents.add(commandContent);
                }
                Command command = new Command();
                command.setName(name);
                command.setDescription(description);
                command.setContentList(commandContents);
                commandService.add(command);

                //跳转
                req.getRequestDispatcher("/list.action").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/jsp/back/addCommand.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/back/addCommand.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
