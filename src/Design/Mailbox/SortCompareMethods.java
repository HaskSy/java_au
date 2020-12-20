package Design.Mailbox;

import java.util.Arrays;
import java.util.List;

public class SortCompareMethods {

    public static List<Message> initMessageList() {
        return Arrays.asList(
                new Message(
                        "windows@engage.windows.com",
                        "sergeykovaltsov@gmail.com",
                        "Get up and running with your new PC....",
                        "",
                        ""),
                new Message(
                        "noreply@stepik.org",
                        "sergeykovaltsov@gmail.com",
                        "Спасибо, что смотрите мои курсы по статистике!...",
                        "",
                        ""),
                new Message(
                        "notify@mail.notion.so",
                        "sergeykovaltsov@gmail.com",
                        "Click here to log in with this magic link...",
                        "",
                        ""),
                new Message(
                        "no-reply@accounts.google.com",
                        "ironmanspb@gmail.com",
                        "Кто-то изменил пароль Вашего аккаунта Google...",
                        "",
                        ""),
                new Message(
                        "ironmanspb@gmail.com",
                        "sergeykovaltsov@gmail.com",
                        "Проверка...",
                        "",
                        "")
        );
    }
}
