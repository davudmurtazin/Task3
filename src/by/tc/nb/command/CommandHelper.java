package by.tc.nb.command;

import java.util.HashMap;
import java.util.Map;

import by.tc.nb.command.Command;
import by.tc.nb.command.impl.*;

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		commands.put("ADD_NEW_NOTE", new AddNewNote());
		commands.put("FIND_NOTE_BY_CONTENT", new FindNoteByContent());
		commands.put("FIND_NOTE_BY_DATE", new FindNoteByDate());
		commands.put("READ_NOTES_FROM_FILE", new ReadNotesFromFile());
		commands.put("SHOW_NOTES", new ShowNotes());
		commands.put("WRITE_NOTES_TO_FILE", new WriteNotesToFile());
		commands.put("CLEAT_NOTEBOOK", new ClearNoteBook());
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}
}
