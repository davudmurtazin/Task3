package by.tc.nb.util.validate;

import by.tc.nb.bean.entity.Note;

/**
 * Created by Davud_Murtazin on 9/30/2016.
 */
public class Validator {

    public static boolean checkContent(String strToFind, Note note){
        if(note.getContent().contains(strToFind)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDate(String dateToFind, Note note) {
        if(note.getDate().contains(dateToFind)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNote(String lineFromFile) {
        String regExp = "(0[1-9]|1[0-9]|2[0-9]|3[01])\\.(0[1-9]|1[012])\\.[0-9]{4}-(.*)";
        if(lineFromFile.matches(regExp)) {
            return true;
        } else {
            return false;
        }
    }
}
