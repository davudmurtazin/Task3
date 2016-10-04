package by.tc.nb.bean;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class WriteNotesToFileRequest extends Request{
    private String filePath;

    public WriteNotesToFileRequest() {
    }

    public WriteNotesToFileRequest(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
