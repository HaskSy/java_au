package Design.Youtube;

public class Channel {

    private String nameChannel;
    private boolean verified;
    private int subscribers;
    private boolean subscribed;

    public Channel(String nameChannel, boolean verified, int subscribers, boolean subscribed) {
        this.nameChannel = nameChannel;
        this.verified = verified;
        this.subscribers = subscribers;
        this.subscribed = subscribed;
    }

    public String getNameChannel() {
        return nameChannel;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public boolean isVerified() {
        return verified;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void switchVerified() {
        this.verified = !verified;
    }

    public void setNameChannel(String nameChannel) {
        this.nameChannel = nameChannel;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public void switchSubscribed() {
        this.subscribed = !subscribed;
    }

    comp
}

