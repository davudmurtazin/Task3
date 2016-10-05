package by.tc.nb.command.impl;

import by.tc.nb.bean.FindNoteByContentRequest;
import by.tc.nb.bean.FindNoteByContentResponse;
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
public class FindNoteByContent implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        FindNoteByContentRequest req = new FindNoteByContentRequest();
        if(request instanceof FindNoteByContentRequest) {
            req = (FindNoteByContentRequest)request;
        } else {
            throw new CommandException("Wrong request!");
        }
        String strToFind = req.getContent();

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        NoteBookUtil.findNotesByContent(strToFind,noteBook);

        FindNoteByContentResponse response = new FindNoteByContentResponse();
        response.setFoundNotes( NoteBookUtil.findNotesByContent(strToFind,noteBook));
        response.setErrorStatus(false);
        response.setResultMessage("Searching string found!");

        return response;

    }
}
