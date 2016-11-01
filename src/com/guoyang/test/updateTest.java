package com.guoyang.test;

import com.guoyang.bean.Command;
import com.guoyang.bean.CommandContent;
import com.guoyang.sevice.CommandService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L'Accordeur on 2016/10/27.
 */
public class updateTest {
    public static void main(String[] args) {
        CommandService commandService = new CommandService();
        CommandContent commandContent = new CommandContent();
//        commandContent.setId("7");
        commandContent.setContent("add test");
//        commandContent.setCommandID("3");
        List<CommandContent> commandContents = new ArrayList<CommandContent>();
        commandContents.add(commandContent);
        Command command = new Command();
//        command.setId("3");
        command.setName("add test");
        command.setDescription("add test");
        command.setContentList(commandContents);

        commandService.add(command);

    }
}
