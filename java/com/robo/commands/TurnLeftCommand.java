package com.robo.commands;

import com.robo.pojo.Direction;
import com.robo.pojo.IRobo;
import com.robo.pojo.Position;

/**
 * Created by Vishal on 14-11-2015.
 */
public class TurnLeftCommand implements ICommand{

    public void execute(IRobo robo) {
        Position roboPosition=robo.getPosition();
        if(roboPosition.getFacing().equals(Direction.EAST)){
            roboPosition.setFacing(Direction.NORTH);
        }
        else if(roboPosition.getFacing().equals(Direction.NORTH)){
            roboPosition.setFacing(Direction.WEST);
        }
        else if(roboPosition.getFacing().equals(Direction.WEST)){
            roboPosition.setFacing(Direction.SOUTH);
        }
        else if(roboPosition.getFacing().equals(Direction.SOUTH)){
            roboPosition.setFacing(Direction.EAST);
        }
    }
}
