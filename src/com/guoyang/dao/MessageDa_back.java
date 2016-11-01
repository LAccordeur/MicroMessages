package com.guoyang.dao;

import com.guoyang.bean.Message;
import com.guoyang.db.DBUtil_back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by L'Accordeur on 2016/10/13.
 */
public class MessageDa_back {

    DBUtil_back dbUtil = new DBUtil_back();
    Connection connection = dbUtil.getConnecion();
    //获取信息列表
    public ArrayList<Message> getAllMessage() {
        ArrayList<Message> messageList = new ArrayList<Message>();
        String sql = "select ID,COMMAND,DESCRIPTION,CONTENT from message";
        PreparedStatement statement;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Message message = new Message();
                messageList.add(message);
                message.setId(resultSet.getString("ID"));
                message.setCommand(resultSet.getString("COMMAND"));
                message.setDescription(resultSet.getString("DESCRIPTION"));
                message.setContent(resultSet.getString("CONTENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return messageList;
    }


    public ArrayList<Message> queryMessage(Message message) {
        //取出要查询的命令
        String command = message.getCommand();
        String description = message.getDescription();

        ArrayList<Message> messages = new ArrayList<Message>();

        //拼接查询语句
        StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
        ArrayList<String> paramList = new ArrayList<String>();

        if (command != null && !"".equals(command.trim())) {
            sql.append(" and COMMAND=?");
            paramList.add(command);
        }
        if (description != null && !"".equals(description.trim())) {
            sql.append(" and DESCRIPTION like '%'?'%'");
            paramList.add(description);
        }

        try {
            PreparedStatement statement = connection.prepareStatement(sql.toString());
            for (int i = 0; i < paramList.size(); i++) {
                statement.setString(i+1,paramList.get(i));
            }
            ResultSet resultSet = null;


            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Message message1 = new Message();
                messages.add(message1);
                message1.setId(resultSet.getString("ID"));
                message1.setCommand(resultSet.getString("COMMAND"));
                message1.setDescription(resultSet.getString("DESCRIPTION"));
                message1.setContent(resultSet.getString("CONTENT"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return messages;
    }
}
