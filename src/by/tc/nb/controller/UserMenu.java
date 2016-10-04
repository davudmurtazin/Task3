package by.tc.nb.controller;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Davud_Murtazin on 10/4/2016.
 */
public class UserMenu {
    private static final Scanner sc = new Scanner(System.in);
    private static final Controller controller = new Controller();

    private void getMenu(){
        System.out.println("Welcome to notebook organizer!=)\n" +
                "Please enter to: \n"+
                "1. Add note \n" +
                "2. Find note by content \n" +
                "3. Find note by date \n" +
                "4. Clear notebook \n" +
                "5. Show all notes \n" +
                "6. Read notes from file \n" +
                "7. Write note to file \n"  +
                "8. Exit");
    }

    public void begin(){
        getMenu();
        int choice = sc.nextInt();
        while(choice!=8){
            switch(choice){
                case 1: addNote(); break;
                case 2: findNoteByContent(); break;
                case 3: findNoteByDate(); break;
                case 4: clearNoteBook(); break;
                case 5: showAllNotes(); break;
                case 6: readNotesFromFile(); break;
                case 7: writeNotesToFile(); break;
                default: System.out.println("Incorrect command! Enter again: "); break;
            }
        }
    }

    private void addNote() {
        System.out.println("Enter note to add: ");
        String content = new Scanner(System.in).nextLine();

        String dateStr = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        AddNoteRequest request = new AddNoteRequest();
        request.setCommandName("ADD_NEW_NOTE");
        request.setNote(content);
        request.setDate(dateStr);

        Response response = controller.doRequest(request);
        if((!response.isErrorStatus())){
            System.out.println(response.getErrorMessage());
        }
    }

    private void findNoteByContent() {
        System.out.println("Enter text to find: ");

        String strFind = sc.nextLine();
        FindNoteByContentRequest request = new FindNoteByContentRequest();
        request.setCommandName("FIND_NOTE_BY_CONTENT");
        request.setContent(strFind);

        FindNoteByContentResponse response;
        response = (FindNoteByContentResponse) controller.doRequest(request);
        System.out.println("Notes containing: " + strFind);
        List<Note> foundNotesByContent;
        foundNotesByContent = response.getFoundNotes();
        if (foundNotesByContent.size()!=0){
            for (Note note : foundNotesByContent) {
                System.out.println(note);
            }
        }
        else
        {
            System.out.println("No matches found!");
        }
        if((!response.isErrorStatus())){
            System.out.println(response.getErrorMessage());
        }
    }

    private void findNoteByDate() {
        System.out.println("Enter date to find: ");
        String dateToFind = sc.nextLine();
        FindNoteByDateRequest request = new FindNoteByDateRequest();
        request.setCommandName("FIND_NOTE_BY_DATE");
        request.setDate(dateToFind);

        FindNoteByContentResponse response;
        response = (FindNoteByContentResponse)controller.doRequest(request);
        List<Note> foundNotesByDate;
        foundNotesByDate = response.getFoundNotes();
        if (foundNotesByDate.size()!=0){
            for (Note note : foundNotesByDate) {
                System.out.println(note);
            }
        }
        else {
            System.out.println("No matches found!");
        }

        if(!response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
    }

    private void clearNoteBook() {
        ClearNoteBookRequest request = new ClearNoteBookRequest();
        request.setCommandName("CLEAT_NOTEBOOK");

        Response response = controller.doRequest(request);
        if(!response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
    }

    private void showAllNotes() {
        ShowNotesRequest request = new ShowNotesRequest();
        request.setCommandName("SHOW_NOTES");

        Response response;
        response = controller.doRequest(request);
        if(!response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
    }

    private void readNotesFromFile() {
        System.out.println("Enter file path to read notes: ");
        String filePath = sc.nextLine();

        ReadNoteFromFileRequest request = new ReadNoteFromFileRequest();
        request.setCommandName("READ_NOTES_FROM_FILE");
        request.setFilePath(filePath);

        Response response;
        response = controller.doRequest(request);
        if(!response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
    }

    private void writeNotesToFile(){
        System.out.println("Enter file path to write notes: ");
        String filePath = sc.nextLine();
        WriteNotesToFileRequest request = new WriteNotesToFileRequest();
        request.setCommandName("WRITE_NOTES_TO_FILE");
        request.setFilePath(filePath);

        Response response;
        response = controller.doRequest(request);
        if(!response.isErrorStatus()){
            System.out.println(response.getErrorMessage());
        }
    }
}
