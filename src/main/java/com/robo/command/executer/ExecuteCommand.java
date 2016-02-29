package com.robo.command.executer;

import java.util.List;

import com.robo.commands.ICommand;
import com.robo.pojo.IRobo;

public class ExecuteCommand {

	public static void execute(List<ICommand> commandList, IRobo robo) throws Exception {
		for (ICommand command : commandList) {
			command.execute(robo);
		}
	}

	public static void execute(ICommand command, IRobo robo) throws Exception {
		command.execute(robo);
	}
}
