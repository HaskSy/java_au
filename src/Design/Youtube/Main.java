package Design.Youtube;


import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Most liked 3 videos");
        SortCompareMethods.getMostLikedNVideosWithLikes(SortCompareMethods.initVideoList(), 3).forEach(System.out::println);
        System.out.println("The 5 newest videos");
        SortCompareMethods.getTheNewestNVideosWithDate(SortCompareMethods.initVideoList(), 5).forEach(System.out::println);
        System.out.println("The 7 most viewed videos");
        SortCompareMethods.getTheMostViewedNVideosWithViews(SortCompareMethods.initVideoList(), 7).forEach(System.out::println);
        System.out.println("Sort by views");
        SortCompareMethods.sortByViews(SortCompareMethods.initVideoList()).forEach(System.out::println);
        System.out.println("Sort by title");
        SortCompareMethods.sortByTitle(SortCompareMethods.initVideoList()).forEach(System.out::println);
        System.out.println("Channel and video Output");
        SortCompareMethods.getChannelAndVideoStringList(SortCompareMethods.initVideoList()).forEach(System.out::println);
        System.out.println("Sort by subscribers");
        SortCompareMethods.sortVideosByChannelSubscribers(SortCompareMethods.initVideoList()).forEach(System.out::println);

    }
}
