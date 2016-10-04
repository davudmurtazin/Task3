package by.tc.nb.bean;

import java.util.Date;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class FindNoteByDateRequest extends Request{
    private String date;

    public FindNoteByDateRequest() {
    }

    public FindNoteByDateRequest(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
