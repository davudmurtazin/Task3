package by.tc.nb.command.impl;

import by.tc.nb.bean.ClearNoteBookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

/**
 * Created by Davud_Murtazin on 9/30/2016.
 */
public class ClearNoteBook implements Command{

    @Override
    public Response execute(Request request) throws CommandException {
        if (request instanceof ClearNoteBookRequest){
            NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
            noteBook.getNotes().clear();

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("NoteBook cleared!");

            return response;
        }
        else {
            throw new CommandException("Wrong command!!!");
        }

    }
}
