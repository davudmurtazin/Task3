package by.tc.nb.bean;

import java.util.Date;

public class AddNoteRequest extends Request {
	private String note;
	private String date;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
