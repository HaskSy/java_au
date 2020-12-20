package Design.Mailbox;

public enum Status {

    SENT("sent"),
    FAILED("failed"),
    DRAFT("draft");

    private String name;

    public String getName() {
        return name;
    }

    Status(String name) {
        this.name = name;
    }


}
