package Design.Youtube;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

public class Video {

    private String title;
    private final Channel channel;
    private long views;
    private final Calendar date;
    private long likes;
    private long dislikes;

    public Video(String title, Channel channel, long views, Calendar date, long likes, long dislikes) {
        this.title = title;
        this.channel = channel;
        this.views = views;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public String getTitle() {
        return title;
    }

    public Channel getChannel() {
        return channel;
    }

    public long getViews() {
        return views;
    }

    public Date getDate() {
        return date.getTime();
    }

    public long getLikes() {
        return likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public String getDateDYM() {
        return date.get(Calendar.DATE) +
                " " +
                new DateFormatSymbols().getMonths()[date.get(Calendar.MONTH)] +
                " " +
                date.get(Calendar.YEAR);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    public static Calendar setDate(int year, int month, int day) {
        Calendar myCal = Calendar.getInstance();
        myCal.set(Calendar.YEAR, year);
        myCal.set(Calendar.MONTH, month - 1);
        myCal.set(Calendar.DAY_OF_MONTH, day);
        return myCal;
    }
}
