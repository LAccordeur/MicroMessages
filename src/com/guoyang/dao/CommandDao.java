package com.guoyang.dao;

import com.guoyang.bean.Command;
import com.guoyang.bean.CommandContent;
import com.guoyang.db.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/26.
 */
public class CommandDao {
    //根据查询条件返回一个或多个Command的List
    public List<Command> queryCommandList(Command command) {

        DBUtil dbUtil = new DBUtil();
        SqlSession sqlSession = null;
        List<Command> commandList = new ArrayList<Command>();
        try {
            //获得数据库连接对象Sqlsession
            sqlSession = dbUtil.getSqlSesion();
            //查询
//            commandList = sqlSession.selectList("Command.queryCommandList",command);
            //利用接口编程
            ICommand iCommand = sqlSession.getMapper(ICommand.class);
            commandList = iCommand.queryCommandList(command);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return commandList;
    }

    //根据ID同时删除单条command与command_content中的符合条件的内容
    public void deleteOne(String id) {

        DBUtil dbUtil = new DBUtil();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbUtil.getSqlSesion();
            //sqlSession.delete("Command.deleteOne",id);
            ICommand iCommand = sqlSession.getMapper(ICommand.class);
            iCommand.deleteOne(id);
            //提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    //根据ID同时删除多条command与command_content中的符合条件的内容
    public void deleteBatch(List<String> ids) {
        DBUtil dbUtil = new DBUtil();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbUtil.getSqlSesion();
//            sqlSession.delete("Command.deleteBatch",ids);
            ICommand iCommand = sqlSession.getMapper(ICommand.class);
            iCommand.deleteBatch(ids);
            //提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    //根据修改的内容对相应信息进行更新
    public void update(Command command) {
        DBUtil dbUtil = new DBUtil();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbUtil.getSqlSesion();
            //进行command表更新
//            sqlSession.update("Command.updateCommand",command);
            ICommand iCommand = sqlSession.getMapper(ICommand.class);
            iCommand.updateCommand(command);
            //进行command_content表更新
            List<CommandContent> contents = command.getContentList();
//            sqlSession.update("Command.updateCommandContent",contents);
            iCommand.updateCommandContent(contents);
            //提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    //添加命令
    public void add(Command command) {
        DBUtil dbUtil = new DBUtil();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbUtil.getSqlSesion();
            //插入命令
//            sqlSession.insert("Command.insertCommand",command);
            ICommand iCommand = sqlSession.getMapper(ICommand.class);
            iCommand.insertCommand(command);
            //获取主键并加入到content
            List<CommandContent> contentList = command.getContentList();
            for (CommandContent content : contentList) {
                content.setCommandID(command.getId());
            }
            //插入命令内容
//            sqlSession.insert("Command.insertCommandContent",contentList);
            iCommand.insertCommandContent(contentList);
            //提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
