package by.tc.nb.command.impl;

import by.tc.nb.bean.FindNoteByDateRequest;
import by.tc.nb.bean.FindNoteByDateResponse;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.util.NoteBookUtil;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class FindNoteByDate implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        FindNoteByDateRequest req;

        if(request instanceof FindNoteByDateRequest) {
            req = (FindNoteByDateRequest) request;
        } else {
            throw new CommandException("Wrong request!");
        }

        String dateToFind = req.getDate();

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        NoteBookUtil.findNotesByDate(dateToFind,noteBook);

        FindNoteByDateResponse response = new FindNoteByDateResponse();
        response.setFoundNotes(NoteBookUtil.findNotesByDate(dateToFind,noteBook));
        response.setErrorStatus(false);
        response.setResultMessage("Searching date found!");

        return response;
    }
}
