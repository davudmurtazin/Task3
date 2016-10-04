package by.tc.nb.bean;

import java.util.ArrayList;

import by.tc.nb.bean.entity.Note;

public class FindNoteByContentResponse extends Response {
	private ArrayList<Note> foundNotes;

	public ArrayList<Note> getFoundNotes() {
		return foundNotes;
	}

	public void setFoundNotes(ArrayList<Note> foundNotes) {
		this.foundNotes = foundNotes;
	}

	
}
