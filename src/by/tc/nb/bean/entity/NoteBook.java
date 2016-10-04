package by.tc.nb.bean.entity;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<Note> notes;

	public NoteBook() {
	}

	public NoteBook(ArrayList<Note> notes) {
		this.notes = notes;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}


}
