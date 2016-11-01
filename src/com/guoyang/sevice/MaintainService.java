package com.guoyang.sevice;

import com.guoyang.bean.Message;
import com.guoyang.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/14.
 */
public class MaintainService {

    public void deleteOne(Message message) {
        MessageDao messageDao = new MessageDao();
        messageDao.deleteOne(message);
    }

    public void deleteBatch(String[] ids) {
        MessageDao messageDao = new MessageDao();
        List<Integer> idList = new ArrayList<Integer>();
        for (String id : ids) {
            idList.add(Integer.valueOf(id));
        }
        messageDao.deleteBatch(idList);
    }
}
