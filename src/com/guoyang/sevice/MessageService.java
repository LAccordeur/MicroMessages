package com.guoyang.sevice;

import com.guoyang.bean.Message;
import com.guoyang.dao.MessageDa_back;
import com.guoyang.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/13.
 */

public class MessageService {
   /* public ArrayList<Message> getAllMessage() {
        MessageDa_back messageDao = new MessageDa_back();
        return messageDao.getAllMessage();
    }*/

    public List<Message> queryMessage(Message message) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessage(message);
    }
}
