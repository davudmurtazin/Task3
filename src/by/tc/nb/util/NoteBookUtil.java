package by.tc.nb.util;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.util.validate.Validator;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class NoteBookUtil {

    public static void addNoteToNoteBook(NoteBook noteBook, Note note) {
        noteBook.getNotes().add(note);
    }

    public static void showAllNotes(NoteBook noteBook) {
        System.out.println("SHOW ALL NOTES");
        for (Note note : noteBook.getNotes()) {
            System.out.println(note);
        }
    }

    public static ArrayList<Note> getAllNotesFromFile(String filePath, NoteBook noteBook) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int dashPosition;
        int contentBegins;
        while ((line = br.readLine()) != null) {
            if (Validator.isNote(line)){
                dashPosition = line.indexOf('-');
                contentBegins = dashPosition + 1;
                Note note = new Note(line.substring(1, dashPosition), line.substring(contentBegins));
                addNoteToNoteBook(noteBook, note);
            }
            else {
                System.out.println("Line in file is not valid");
            }
        }
        br.close();
        return noteBook.getNotes();
    }

    public static ArrayList<Note> findNotesByContent(String strToFind, NoteBook noteBook) {
        ArrayList<Note> findNotes = new ArrayList<>();
        for (Note note : noteBook.getNotes()) {
            if (Validator.checkContent(strToFind, note)) {
                findNotes.add(note);
            }
        }
        return findNotes;
    }

    public static ArrayList<Note> findNotesByDate(String dateToFind, NoteBook noteBook) {
        ArrayList<Note> foundNotes = new ArrayList<>();
        if (!noteBook.getNotes().isEmpty()){
            for (Note note : noteBook.getNotes()) {
                if (Validator.checkDate(dateToFind, note)) {
                   foundNotes.add(note);
                }
            }

        } else {
            System.out.println("Notes with this date didn't found!");
        }
        return foundNotes;
    }

    public static void writeAllNotesToFile(String filePath, NoteBook notebook) throws IOException{

        try{
            PrintWriter fw = new PrintWriter(filePath);
            for (Note note : notebook.getNotes()){
                fw.println(note.toString());
            }
            System.out.println("Access written to file!");
        }catch (IOException e){
            new NoteBookUtilException("Can not write to file!");
        }finally {
            //fw.close();
        }


    }
}

