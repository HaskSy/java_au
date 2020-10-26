package Design.Youtube;


import javax.swing.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class SortCompareMethods {

    public static List<String> getMostLikedNVideosWithLikes(List<Video> videos, int n) {
        return videos.stream()
                .sorted(Comparator.comparingLong(Video::getLikes).reversed())
                .limit(n)
                .map(x -> String.join("\n Likes: ", x.getTitle(), String.valueOf(x.getLikes())))
                .collect(Collectors.toList());
    }

    public static List<String> getTheNewestNVideosWithDate(List<Video> videos, int n) {
        return videos.stream()
                .sorted(Comparator.comparing(Video::getDate).reversed())
                .limit(n)
                .map(x -> String.join("\n Published: ", x.getTitle(), x.getDateDYM()))
                .collect(Collectors.toList());

    }

    public static List<String> getTheMostViewedNVideosWithViews(List<Video> videos, int n) {
        return videos.stream()
                .sorted(Comparator.comparing(Video::getViews).reversed())
                .limit(n)
                .map(x -> String.join("\n Views: ", x.getTitle(), String.valueOf(x.getViews())))
                .collect(Collectors.toList());
    }

    private static List<String> defineSortParams(List<Video> videos, Comparator<Video> comparing, boolean reversed) {
        AtomicInteger counter = new AtomicInteger();
        Stream<Video> stream = videos.stream();
        if (!reversed) stream = stream.sorted(comparing);
        else stream = stream.sorted(comparing.reversed());
        return stream.map(x -> String.join(") ", String.valueOf(counter.incrementAndGet()), x.getTitle()))
                .collect(Collectors.toList());
    }

    public static List<String> sortByViews(List<Video> videos, boolean reversed) {
        return defineSortParams(videos, Comparator.comparing(Video::getViews), reversed);
    }

    public static List<String> sortByViews(List<Video> videos) {
        return sortByViews(videos, false);
    }

    public static List<String> sortByLikes(List<Video> videos, boolean reversed) {
        return defineSortParams(videos, Comparator.comparing(Video::getLikes), reversed);
    }

    public static List<String> sortByLikes(List<Video> videos) {
        return sortByLikes(videos, false);
    }

    public static List<String> sortByDislikes(List<Video> videos, boolean reversed) {
        return defineSortParams(videos, Comparator.comparing(Video::getDislikes), reversed);
    }

    public static List<String> sortByDislikes(List<Video> videos) {
        return sortByDislikes(videos, false);
    }

    public static List<String> sortByTitle(List<Video> videos, boolean reversed) {
        return defineSortParams(videos, Comparator.comparing(Video::getTitle), reversed);
    }

    public static List<String> sortByTitle(List<Video> videos) {
        return sortByTitle(videos, false);
    }

    public static List<String> sortByDate(List<Video> videos, boolean reversed) {
        return defineSortParams(videos, Comparator.comparing(Video::getDate), reversed);
    }

    public static List<String> sortByDate(List<Video> videos) {
        return sortByDate(videos, false);
    }

    public static Map<Channel, Video> VideoListToChannelVideoMap(List<Video> videos) {
        List<Channel> channels = videos.stream()
                .map(Video::getChannel)
                .collect(Collectors.toList());
        return IntStream.range(0, videos.size()).boxed()
                .collect(Collectors.toMap(channels::get, videos::get));
    }

    public static List<String> getChannelAndVideoStringList(List<Video> videos) {
        return VideoListToChannelVideoMap(videos).entrySet().stream()
                .map(x -> String.join(": ", x.getKey().getNameChannel(), x.getValue().getTitle()))
                .collect(Collectors.toList());
    }

    public static List<String> sortVideosByChannelSubscribers(List<Video> videos, boolean reversed) {
            AtomicInteger counter = new AtomicInteger();
            Map<Channel, Video> channelVideoMap = VideoListToChannelVideoMap(videos);
            Stream<Channel> channels = videos.stream().map(Video::getChannel);
            if (!reversed) channels = channels.sorted(Comparator.comparing(Channel::getSubscribers));
            else channels = channels.sorted(Comparator.comparing(Channel::getSubscribers).reversed());
            return channels.map(x ->
                            counter.incrementAndGet() +
                            ") \n Channel: " + x.getNameChannel() +
                            "\n Subscribers: " + x.getSubscribers() +
                            "\n Video: " + channelVideoMap.get(x).getTitle()
            ).collect(Collectors.toList());
    }

    public static List<String> sortVideosByChannelSubscribers(List<Video> videos) {
        return sortVideosByChannelSubscribers(videos, false);
    }

    public static List<Video> initVideoList() {
        return Arrays.asList(
                new Video("Hozier - Take Me To Church - Electric Guitar Cover by Kfir Ochaion",
                        new Channel(
                                "Kfir Ochaion",
                                true,
                                1260000,
                                true
                        ),
                        295736,
                        Video.setDate(2020, 4, 16),
                        15159,
                        77
                ),
                new Video("Crushing a Finn",
                        new Channel(
                                "GMHikaru",
                                true,
                                384000,
                                true
                        ),
                        34756,
                        Video.setDate(2020, 3, 28),
                        695,
                        14
                ),
                new Video("When you have perfect pitch",
                        new Channel(
                                "Daniel Thrasher",
                                true,
                                2020000,
                                false
                        ),
                        1424702,
                        Video.setDate(2020, 9, 30),
                        168121,
                        461
                ),
                new Video("Ковбой Бибоп на самом деле кино",
                        new Channel(
                                "...and Action!",
                                true,
                                174000,
                                true
                        ),
                        163540,
                        Video.setDate(2019, 12, 22),
                        18389,
                        107
                ),
                new Video("Half the universe was missing... until now",
                        new Channel(
                                "Veritasium",
                                true,
                                7740000,
                                false
                        ),
                        2211291,
                        Video.setDate(2020, 9, 1),
                        121438,
                        2274
                ),
                new Video("Linkin Park - Breaking the Habit (Cover на русском от RADIO TAPOK)",
                        new Channel(
                                "RADIO TAPOK",
                                true,
                                1940000,
                                true
                        ),
                        940582,
                        Video.setDate(2020, 6, 6),
                        86415,
                        1180
                ),
                new Video("Part 2, Level 1: Modelling - Beginner Blender Tutorial Series",
                        new Channel(
                                "Blender Guru",
                                true,
                                1500000,
                                false
                        ),
                        2726917,
                        Video.setDate(2019, 9, 4),
                        61150,
                        632
                )
        );
    }
}
