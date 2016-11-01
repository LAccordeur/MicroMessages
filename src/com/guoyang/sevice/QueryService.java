package com.guoyang.sevice;

import java.util.List;
import java.util.Random;

import com.guoyang.bean.Command;
import com.guoyang.bean.CommandContent;
import com.guoyang.bean.Message;
import com.guoyang.dao.CommandDao;
import com.guoyang.dao.MessageDao;
import com.guoyang.util.Iconst;

/**
 * 查询相关的业务功能
 */
public class QueryService {
	public List<Message> queryMessageList(String command,String description) {
		MessageDao messageDao = new MessageDao();
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		return messageDao.queryMessage(message);
	}
	
	/**
	 * 通过指令查询自动回复的内容
	 * @param command 指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		Command command1 = new Command();
		command1.setName(command);
		commandList = commandDao.queryCommandList(command1);
		if(commandList.size() > 0) {
			List<CommandContent> commandContents= commandList.get(0).getContentList();
			return commandContents.get(new Random().nextInt(commandContents.size())).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
