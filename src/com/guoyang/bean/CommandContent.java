package com.guoyang.bean;

/**
 * Created by L'Accordeur on 2016/10/24.
 */
public class CommandContent {
    //主键
    private String id;
    //自动回复内容
    private String content;
    //关联的指令表主键
    private String commandID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommandID() {
        return commandID;
    }

    public void setCommandID(String commandID) {
        this.commandID = commandID;
    }
}
