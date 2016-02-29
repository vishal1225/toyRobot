package com.robo.commands;

import com.robo.pojo.Direction;
import com.robo.pojo.IRobo;
import com.robo.pojo.Position;

/**
 */
public class ForwardCommand implements ICommand {
	
    public void execute(IRobo robo) throws Exception {
        Position roboPosition=robo.getPosition();
        if(roboPosition.getFacing().equals(Direction.EAST)){
        	if(roboPosition.getY()+1 < MAX_Y){
        		roboPosition.setY(roboPosition.getY()+1);
        	}
        	else{
        		throw new Exception("Game Over robo is out of grid");
        	}
        }
        else if(roboPosition.getFacing().equals(Direction.NORTH)){
            if(roboPosition.getX()+1<MAX_X){
            	roboPosition.setX(roboPosition.getX()+1);
            }
            else{
        		throw new Exception("Game Over robo is out of grid");
        	}
        }
        else if(roboPosition.getFacing().equals(Direction.WEST)){
            if(roboPosition.getY()-1 > MIN_Y){
            	roboPosition.setY(roboPosition.getY()-1);
            }
            else{
        		throw new Exception("Game Over robo is out of grid");
        	}

        }
        else if(roboPosition.getFacing().equals(Direction.SOUTH)){
            if(roboPosition.getX()-1>MIN_X){
            	roboPosition.setX(roboPosition.getX()-1);            	
            }
            else{
        		throw new Exception("Game Over robo is out of grid");
        	}
        }
    }
}
