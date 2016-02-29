package com.robo.commands;

import com.robo.pojo.IRobo;
import com.robo.pojo.Position;

/**
 */
public class GpsReportCommand implements ICommand {
    public void execute(IRobo robo) {
        Position roboPosition=robo.getPosition();
        System.out.println("coordinate x and y:" +roboPosition.getX()+", "+roboPosition.getY());
        System.out.println("Moving towards: "+roboPosition.getFacing());
    }
}
