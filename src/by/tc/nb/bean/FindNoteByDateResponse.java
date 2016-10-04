package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.List;

/**
 * Created by Davud_Murtazin on 9/30/2016.
 */
public class FindNoteByDateResponse extends Response{
    private List<Note> findNotes;

    public List<Note> getFindNotes() {
        return findNotes;
    }

    public void setFindNotes(List<Note> findNotes) {
        this.findNotes = findNotes;
    }
}
