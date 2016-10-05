package by.tc.nb.util;

/**
 * Created by Davud_Murtazin on 10/6/2016.
 */
public class NoteBookUtilException  extends Exception{
    public NoteBookUtilException() {
    }

    public NoteBookUtilException(String message) {
        super(message);
    }

    public NoteBookUtilException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteBookUtilException(Throwable cause) {
        super(cause);
    }

    public NoteBookUtilException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
