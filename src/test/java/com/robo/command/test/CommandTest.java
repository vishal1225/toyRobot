package com.robo.command.test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import com.robo.command.executer.ExecuteCommand;
import com.robo.command.reader.ReadCommandFromFile;
import com.robo.commands.MoveCommand;
import com.robo.commands.ICommand;
import com.robo.commands.PlaceCommand;
import com.robo.commands.LeftCommand;
import com.robo.commands.RightCommand;
import com.robo.pojo.Direction;
import com.robo.pojo.IRobo;
import com.robo.pojo.Position;
import com.robo.pojo.ToyRobo;

import junit.framework.TestCase;

public class CommandTest extends TestCase {
	// need a robo
	// need robo position
	// need coordinates and direction for Position
	IRobo robo = new ToyRobo();

	// need place Command
	public void testPlaceCommand() throws Exception {
		ICommand command = new PlaceCommand(new Position(0, 0, Direction.NORTH));
		command.execute(robo);
		assertTrue(robo.getPosition().getX() == 0);
		assertTrue(robo.getPosition().getY() == 0);
		assertTrue(robo.getPosition().getFacing() == Direction.NORTH);
	}

	// need left Command
	public void testTurnLeftCommand() throws Exception {
		ICommand command = new PlaceCommand(new Position(0, 0, Direction.NORTH));
		command.execute(robo);
		command = new LeftCommand();
		command.execute(robo);
		assertTrue(robo.getPosition().getX() == 0);
		assertTrue(robo.getPosition().getY() == 0);
		assertTrue(robo.getPosition().getFacing() == Direction.WEST);
	}

	// need right Command
	public void testTurnRightCommand() throws Exception {
		ICommand command = new PlaceCommand(new Position(0, 0, Direction.NORTH));
		command.execute(robo);
		command = new RightCommand();
		command.execute(robo);
		assertTrue(robo.getPosition().getX() == 0);
		assertTrue(robo.getPosition().getY() == 0);
		assertTrue(robo.getPosition().getFacing() == Direction.EAST);
	}

	// need Move Command
	public void testMoveCommand() throws Exception {
		ICommand command = new PlaceCommand(new Position(0, 0, Direction.NORTH));
		command.execute(robo);
		command = new MoveCommand();
		command.execute(robo);
		assertTrue(robo.getPosition().getX() == 1);
		assertTrue(robo.getPosition().getY() == 0);
		assertTrue(robo.getPosition().getFacing() == Direction.NORTH);
	}

	public void testRobo() throws URISyntaxException, Exception {

		ReadCommandFromFile readFileData = new ReadCommandFromFile();
		try {
			List<ICommand> commandList = readFileData.readFromFile(
					new File(ReadCommandFromFile.class.getClassLoader().getResource("testing.txt").toURI()));
			ExecuteCommand.execute(commandList, robo);
		} catch (IllegalArgumentException exception) {
			exception.printStackTrace();
		}
		assertTrue(robo.getPosition().getX() == 1);
		assertTrue(robo.getPosition().getY() == 0);
		assertTrue(robo.getPosition().getFacing() == Direction.WEST);

	}

}
