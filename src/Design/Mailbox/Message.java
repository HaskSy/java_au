package Design.Mailbox;

public class Message {

    private final String from;
    private final String to;
    private final String content;
    private String tags;
    private String status;


    public Message(String from, String to, String content, String tags, String status) {
        this.from = from;
        this.to = to;
        this.content = content;
        this.tags = tags;
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public String getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
