package com.robo.command.reader.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.robo.command.reader.ReadCommandFromFile;
import com.robo.commands.ICommand;

import junit.framework.TestCase;

public class ReadCommandsFromFileTest extends TestCase {
	public void testReadFromFile() throws Exception {
		ReadCommandFromFile readFileData = new ReadCommandFromFile();
		List<ICommand> commandList = null;
		File file=new File(ReadCommandFromFile.class.getClassLoader().getResource("testing.txt").toURI());
		commandList = readFileData
				.readFromFile(file);
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String sCurrentLine;
		int lineCount=0;
		while ((sCurrentLine = reader.readLine()) != null) {
			lineCount++;
		}
		assertNotNull(commandList);
		assertTrue(commandList.size()==lineCount-1);
	}
}
