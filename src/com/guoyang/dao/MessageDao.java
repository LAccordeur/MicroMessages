package com.guoyang.dao;

import com.guoyang.bean.Message;
import com.guoyang.db.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/14.
 */
public class MessageDao {
    public List<Message> queryMessage(Message message) {
//        List<Message> messages = new ArrayList<Message>();
        List<Message> messages = null;
        //获得SQLSession
        DBUtil dbUtil = new DBUtil();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbUtil.getSqlSesion();
            //通过SQLSession执行Sql语句
            messages = sqlSession.selectList("Message.queryMessageList",message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return messages;
    }

    public void deleteOne(Message message) {
        //获得SQLSession
        DBUtil dbUtil = new DBUtil();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbUtil.getSqlSesion();
            //通过SQLSession执行Sql语句
            sqlSession.delete("Message.deleteOne",message.getId());
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }


    public void deleteBatch(List<Integer> ids) {
        //获得SQLSession
        DBUtil dbUtil = new DBUtil();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbUtil.getSqlSesion();
            //通过SQLSession执行Sql语句
             sqlSession.selectList("Message.deleteBatch",ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }


}
