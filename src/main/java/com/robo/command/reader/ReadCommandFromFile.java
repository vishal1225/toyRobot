package com.robo.command.reader;


import static com.robo.pojo.Command.PLACE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.robo.command.executer.ExecuteCommand;
import com.robo.commands.MoveCommand;
import com.robo.commands.ReportCommand;
import com.robo.commands.ICommand;
import com.robo.commands.PlaceCommand;
import com.robo.commands.LeftCommand;
import com.robo.commands.RightCommand;
import com.robo.pojo.Command;
import com.robo.pojo.Direction;
import com.robo.pojo.IRobo;
import com.robo.pojo.Position;
import com.robo.pojo.ToyRobo;
public class ReadCommandFromFile {
	private final int xCordinate = 5;
	private final int yCordinate = 5;

	public List<ICommand> readFromFile(File file) throws Exception {

		List<ICommand> commandList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null) {
			final String[] split = sCurrentLine.split("\\s*(,|\\s)");
			if (commandList.isEmpty()) {
				if (checkValidInitCommand(split)) {
					commandList.add(new PlaceCommand(createPosition(split)));
				}
				// Discard any command other than initial PLACE
				else {
					continue;
				}
			} else {
				if (split.length == 1) {
					commandList.add(identifyCommand(Command.valueOf(split[0])));
				} else if (checkValidInitCommand(split)) {
					commandList.add(new PlaceCommand(createPosition(split)));
				} else {
					// seems to be an invalid command. Ignore it
					continue;
				}
			}
		}
		br.close();
		return commandList;
	}

	private Position createPosition(String[] split) {
		int x = Integer.parseInt(split[1]);
		int y = Integer.parseInt(split[2]);
		Direction direction = Direction.valueOf(split[3]);
		return new Position(x, y, direction);
	}

	private boolean checkValidInitCommand(String[] split) {
		if ((Command.valueOf(split[0]).equals(PLACE)) && (split.length == 4)) {
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[2]);
			Direction direction = Direction.valueOf(split[3]);
			if ((x >= 0 && x < xCordinate) && (y >= 0 && y < yCordinate)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private ICommand identifyCommand(Command command) {
		ICommand concreteCommand = null;
		if (command.equals(Command.FORWARD)) {
			concreteCommand = new MoveCommand();
		}
		if (command.equals(Command.TURN_LEFT)) {
			concreteCommand = new LeftCommand();
		}
		if (command.equals(Command.TURN_RIGHT)) {
			concreteCommand = new RightCommand();
		}
		if (command.equals(Command.REPORT)) {
			concreteCommand = new ReportCommand();
		}
		return concreteCommand;
	}

	public static void main(String[] args) throws Exception {
		ReadCommandFromFile readFileData = new ReadCommandFromFile();
		IRobo iRobo=new ToyRobo();
		try {
			List<ICommand> commandList=readFileData.readFromFile(
					new File(ReadCommandFromFile.class.getClassLoader().getResource("testing.txt").toURI()));
			ExecuteCommand.execute(commandList, iRobo);
		} catch (IllegalArgumentException exception) {
			exception.printStackTrace();
		}
	}
}
