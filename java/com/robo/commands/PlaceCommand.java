package com.robo.commands;

import com.robo.pojo.IRobo;
import com.robo.pojo.Position;

/**
 * Created by Vishal on 14-11-2015.
 */
public class PlaceCommand implements ICommand{
    Position initPosition;
    public PlaceCommand(Position position) {
	   this.initPosition=position;
    }
    public void execute(IRobo robo) throws Exception {
    	if(initPosition.getX()<=MAX_X && initPosition.getX()>=MIN_X && initPosition.getY()>=MIN_Y && initPosition.getY()<=MAX_Y){
    		robo.setPosition(initPosition);
    	}
    	else{
    		throw new Exception("Game Over robo is out of grid");
    	}
        
    }
}
