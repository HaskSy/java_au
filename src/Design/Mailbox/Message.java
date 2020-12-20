package Design.Mailbox;

public class Message {

    private final String from;
    private final String to;
    private final String content;
    private Tags tags;
    private Status status;


    public Message(String from, String to, String content, Tags tags, Status status) {
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

    public Tags getTags() {
        return tags;
    }

    public Status getStatus() {
        return status;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message\n" +
                "   from: " + from + '\n' +
                "   to: " + to + "\n" +
                "   tags: " + tags + '\n' +
                "   status: " + status + "\n\n" +
                "       " + content + '\n';
    }
}
