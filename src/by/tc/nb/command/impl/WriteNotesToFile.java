package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.WriteNotesToFileRequest;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.util.NoteBookUtil;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class WriteNotesToFile implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        if(request instanceof WriteNotesToFileRequest) {
            NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
            try {
                NoteBookUtil.writeAllNotesToFile(((WriteNotesToFileRequest)request).getFilePath(),noteBook);
            } catch (FileNotFoundException e) {
                throw new CommandException("Wrong path to the file! Try another time.");
            }
            catch (IOException e){
                throw new CommandException("IOException");
            }

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("All notes wrote to file!");
            return response;
        } else {
            throw new CommandException("Wrong request!");
        }
    }
}
