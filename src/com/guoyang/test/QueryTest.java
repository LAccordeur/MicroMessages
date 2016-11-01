package com.guoyang.test;

import com.guoyang.bean.Command;
import com.guoyang.bean.Message;
import com.guoyang.dao.CommandDao;
import com.guoyang.sevice.MessageService;

import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/24.
 */
public class QueryTest {
    public static void  main(String[] args) {
        MessageService messageService = new MessageService();
        Message message = new Message();
        message.setCommand("段子");
        List<Message> messageList = messageService.queryMessage(message);

        for (Message message1 : messageList) {
            System.out.println(message1.getContent());
        }

        CommandDao commandDao = new CommandDao();
        Command command = new Command();
        command.setName("段子");
    }
}
