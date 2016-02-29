package com.robo.commands;

import com.robo.pojo.IRobo;
import com.robo.pojo.Position;

/**
 */
public class ReportCommand implements ICommand {
	public void execute(IRobo robo) {
		Position roboPosition = robo.getPosition();
		System.out.println("coordinate x :" + roboPosition.getX() + " and y:" + roboPosition.getY()
				+ " Moving towards: " + roboPosition.getFacing());
	}
}
