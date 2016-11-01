package com.guoyang.sevice;

import com.guoyang.bean.Command;
import com.guoyang.dao.CommandDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/26.
 */
public class CommandService {
    //查询命令列表
    public List<Command> queryCommandList(Command command) {
        CommandDao commandDao = new CommandDao();
        List<Command> commandList = commandDao.queryCommandList(command);
        return commandList;
    }

    //删除单条
    public void deleteOne(String id) {
        CommandDao commandDao = new CommandDao();
        commandDao.deleteOne(id);
    }

    //删除多条
    public void deleteBatch(String[] ids) {
        List<String> idList = new ArrayList<String>();
        for (String id : ids) {
            idList.add(id);
        }
        CommandDao commandDao = new CommandDao();
        commandDao.deleteBatch(idList);
    }

    //更新数据
    public void update(Command command) {
        CommandDao commandDao = new CommandDao();
        commandDao.update(command);
    }

    //添加数据
    public void add(Command command) {
        CommandDao commandDao = new CommandDao();
        commandDao.add(command);
    }
}
