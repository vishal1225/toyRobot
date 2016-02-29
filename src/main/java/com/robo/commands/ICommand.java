package com.robo.commands;

import com.robo.pojo.IRobo;
import com.robo.util.ResourceUtil;

/**
 */
public interface ICommand {
	static int MAX_Y = Integer.parseInt(ResourceUtil.getPropertyValue("max.y"));
	static int MAX_X = Integer.parseInt(ResourceUtil.getPropertyValue("max.x"));
	static int MIN_X = Integer.parseInt(ResourceUtil.getPropertyValue("min.x"));
	static int MIN_Y = Integer.parseInt(ResourceUtil.getPropertyValue("min.y"));

	public void execute(IRobo robo) throws Exception;
}
