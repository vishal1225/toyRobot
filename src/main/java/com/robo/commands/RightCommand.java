package com.robo.commands;

import com.robo.pojo.Direction;
import com.robo.pojo.IRobo;
import com.robo.pojo.Position;

/**
 */
public class RightCommand implements ICommand {
    public void execute(IRobo robo) {
        Position roboPosition=robo.getPosition();
        if(roboPosition.getFacing().equals(Direction.EAST)){
            roboPosition.setFacing(Direction.SOUTH);
        }
        else if(roboPosition.getFacing().equals(Direction.SOUTH)){
            roboPosition.setFacing(Direction.WEST);
        }
        else if(roboPosition.getFacing().equals(Direction.WEST)){
            roboPosition.setFacing(Direction.NORTH);
        }
        else if(roboPosition.getFacing().equals(Direction.NORTH)){
            roboPosition.setFacing(Direction.EAST);
        }
    }
}
