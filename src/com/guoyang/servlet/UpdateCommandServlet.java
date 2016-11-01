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
 * 处理命令修改
 */
public class UpdateCommandServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");

        //接收页面传值
        String type = req.getParameter("type");

        if ("goUpdate".equals(type)) {
            String id = req.getParameter("id");
            Command command = new Command();
            command.setId(id);
            //取得要更新修改的数据
            CommandService commandService = new CommandService();

            List<Command> commandList = commandService.queryCommandList(command);
            List<CommandContent> commandContents = null;
            Command commandResponse = null;

            //未写按ID查询的query语句故返回整个列表需判断
            for (Command command1 : commandList) {
                if ((command1.getId()).equals(id)) {
                    commandContents = command1.getContentList();
                    commandResponse = command1;
                }
            }
            req.setAttribute("commandList", commandResponse);
            req.setAttribute("commandContents",commandContents);
            req.getRequestDispatcher("/WEB-INF/jsp/back/updateCommand.jsp").forward(req, resp);


        } else if ("goCommit".equals(type)) {
            //接收参数
            String commandID = req.getParameter("commandID");
            String commandName = req.getParameter("commandName");
            String commandDescription = req.getParameter("commandDescription");
            String[] commandContentIDs = req.getParameterValues("commandCOntentID");
            String[] commandContents = req.getParameterValues("commandContent");

            //消息内容列表的封装
            List<CommandContent> contents = new ArrayList<CommandContent>();
            for (int i=0;i < commandContentIDs.length;i++) {
                CommandContent commandContent = new CommandContent();
                commandContent.setId(commandContentIDs[i]);
                commandContent.setContent(commandContents[i]);
                commandContent.setCommandID(commandID);
                contents.add(commandContent);
            }
            //命令内容封装
            Command command = new Command();
            command.setId(commandID);
            command.setDescription(commandDescription);
            command.setName(commandName);
            command.setContentList(contents);

            //传输
            CommandService commandService = new CommandService();
            commandService.update(command);

            req.getRequestDispatcher("/list.action").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
