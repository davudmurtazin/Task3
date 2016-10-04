package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ShowNotesRequest;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.bean.util.NoteBookUtil;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class ShowNotes implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        if(request instanceof ShowNotesRequest) {

            NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
            NoteBookUtil.showAllNotes(noteBook);

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("Show all notes!");

            return response;
        } else {
            throw new CommandException("Wrong request!");
        }
    }
}
