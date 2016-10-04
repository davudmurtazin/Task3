package by.tc.nb.command.impl;

import by.tc.nb.bean.ReadNoteFromFileRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.bean.util.NoteBookUtil;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

import java.io.IOException;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class ReadNotesFromFile implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
       // ReadNoteFromFileRequest req = new ReadNoteFromFileRequest();

        if (request instanceof ReadNoteFromFileRequest){
            NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
            try{
                NoteBookUtil.getAllNotesFromFile(((ReadNoteFromFileRequest) request).getFilePath(), noteBook);
            }catch (IOException e){
                throw new CommandException("Wrong path to the file!");
            }

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("All notes read from file!");

            return response;

        } else {
            throw new CommandException("Wrong request!");
        }
    }
}


