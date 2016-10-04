package by.tc.nb.bean.util;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.bean.util.validate.Validator;
import by.tc.nb.command.exception.CommandException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class NoteBookUtil {

    public static void addNoteToNoteBook(NoteBook noteBook, Note note) {
        noteBook.getNotes().add(note);
    }

    public static void showAllNotes(NoteBook noteBook) {
        for (Note note : noteBook.getNotes()) {
            System.out.println(note);
        }
    }

    public static ArrayList<Note> getAllNotesFromFile(String filePath, NoteBook noteBook) throws IOException {
        File file = new File(filePath);
        Scanner sc = new Scanner(new FileReader(file));
        String line;
        int spacePosition;
        int contentBegins;
        while ((line = sc.nextLine()) != null) {
            spacePosition = line.indexOf(' ');
            contentBegins = spacePosition + 2;
            Note note = new Note(line.substring(spacePosition), line.substring(contentBegins));
            addNoteToNoteBook(noteBook, note);
        }
        sc.close();
        return noteBook.getNotes();
    }

    public static ArrayList<Note> findNotesByContent(String strToFind, NoteBook noteBook) {
        ArrayList<Note> findNotes = new ArrayList<Note>();
        for (Note note : noteBook.getNotes()) {
            if (Validator.checkContent(strToFind, note)) {
                findNotes.add(note);
            }
        }
        return findNotes;
    }

    public static ArrayList<Note> findNotesByDate(String dateToFind, NoteBook noteBook) {
        ArrayList<Note> findNotes = new ArrayList<Note>();
        for (Note note : noteBook.getNotes()) {
            if (Validator.checkDate(dateToFind, note)) {
                findNotes.add(note);
            }
        }
        return findNotes;
    }

    public static void writeAllNotesToFile(String filePath, NoteBook notebook) throws IOException{
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8));
        for (Note note : notebook.getNotes()){
            writer.write(note.toString());
        }
        writer.close();
    }
}

