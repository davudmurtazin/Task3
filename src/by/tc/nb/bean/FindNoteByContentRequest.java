package by.tc.nb.bean;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class FindNoteByContentRequest extends Request{
    private String content;

    public FindNoteByContentRequest() {
    }

    public FindNoteByContentRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
