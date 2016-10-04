package by.tc.nb.bean.util.validate;

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

    public static boolean isNote(String inputString) {
        String regExp = "^\\[(([1-9])|(1[012])) (([1-9])|([12]\\d)|(3[01])) ((\\d){4})\\] (.*)";
        if(inputString.matches(regExp)) {
            return true;
        } else {
            return false;
        }
    }
}
