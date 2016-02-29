package com.robo.pojo;

/**
 * Created by Vishal on 12-11-2015.
 */
public enum Command {
	PLACE("PLACE"), FORWARD("FORWARD"), TURN_LEFT("TURN_LEFT"), TURN_RIGHT("TURN_RIGHT"), REPORT("REPORT");
	private String commandType;

	private Command(String cType) {
		commandType = cType;

	}

	public String getCommandType() {
		return commandType;
	}
}
