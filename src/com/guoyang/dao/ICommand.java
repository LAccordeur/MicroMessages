package com.guoyang.dao;

import com.guoyang.bean.Command;
import com.guoyang.bean.CommandContent;

import java.util.List;

/**
 * Created by L'Accordeur on 2016/11/13.
 * 与Command配置文件相对应的接口
 */
public interface ICommand {
    public List<Command> queryCommandList(Command command);

    public void deleteOne(String id);

    public void deleteBatch(List<String> ids);

    public void updateCommand(Command command);

    public void updateCommandContent(List<CommandContent> commandContents);

    public void insertCommand(Command command);

    public void insertCommandContent(List<CommandContent> commandContents);
}
