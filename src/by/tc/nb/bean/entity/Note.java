package by.tc.nb.bean.entity;

public class Note {
    private String content;
    private String date;

    public Note(){
    }

    public Note(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date + "-" + content;
    }
}
