package com.guoyang.bean;

import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/24.
 */
public class Command {
    //主键
    private String id;
    //命令名
    private String name;
    //描述
    private String description;
    //一条指令对应的自动回复内容列表
    private List<CommandContent> contentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CommandContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<CommandContent> contentList) {
        this.contentList = contentList;
    }
}
