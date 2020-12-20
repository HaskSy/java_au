package Design.Mailbox;

public class Main {
    public static void main(String[] args) {
        System.out.println("Show All Messages");
        SortCompareMethods.showAllMessages(SortCompareMethods.initMessageList());


        System.out.println("Show by Tags");
        SortCompareMethods.getAllMessagesByTag(SortCompareMethods.initMessageList(), "").forEach(System.out::println);


        System.out.println("Show Messages From");
        SortCompareMethods.getAllMessagesFrom(SortCompareMethods.initMessageList(), "ironmanspb@gmaill.com");


        System.out.println("Show Messages To");
        SortCompareMethods.getAllMessagesTo(SortCompareMethods.initMessageList(), "ironmanspb@gmaill.com");



    }
}
