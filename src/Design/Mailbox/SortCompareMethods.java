package Design.Mailbox;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortCompareMethods {

    public static List<Message> initMessageList() {
        return Arrays.asList(
                new Message(
                        "windows@engage.windows.com",
                        "sergeykovaltsov@gmail.com",
                        "Get up and running with your new PC....",
                        Tags.UNTAGGED,
                        Status.SENT),
                new Message(
                        "noreply@stepik.org",
                        "sergeykovaltsov@gmail.com",
                        "Спасибо, что смотрите мои курсы по статистике!...",
                        Tags.MARKED,
                        Status.SENT),
                new Message(
                        "notify@mail.notion.so",
                        "sergeykovaltsov@gmail.com",
                        "Click here to log in with this magic link...",
                        Tags.IMPORTANT,
                        Status.SENT),
                new Message(
                        "no-reply@accounts.google.com",
                        "ironmanspb@gmail.com",
                        "Кто-то изменил пароль Вашего аккаунта Google...",
                        Tags.UNTAGGED,
                        Status.FAILED),
                new Message(
                        "ironmanspb@gmail.com",
                        "sergeykovaltsov@gmail.com",
                        "Проверка...",
                        Tags.UNTAGGED,
                        Status.DRAFT)
        );
    }

    public static List<Message> getAllMessagesFrom (List<Message> list, String sender) {
        return list.stream()
                .filter(p -> p.getFrom().equals(sender))
                .collect(Collectors.toList());
    }

    public static List<Message> getAllMessagesTo(List<Message> list, String responder) {
        return list.stream()
                .filter(p -> p.getTo().equals(responder))
                .collect(Collectors.toList());
    }

    public static void showAllMessages(List<Message> messages) {
        messages.forEach(p -> System.out.println(p.toString()));
    }

    public static List<Message> getAllMessagesByTag(List<Message> list, String tag) {
        return list.stream().filter(p -> p.getTags().getName().equals(tag)).collect(Collectors.toList());
    }



}
