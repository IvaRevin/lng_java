package homework.patternExamples.behavioral;

import java.util.*;

public class MediatorExample {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        ChatUser admin = new Admin(chat, "Иван Иванов");

        ChatUser u1 = new SimpleChatUser(chat, "Олег");
        ChatUser u2 = new SimpleChatUser(chat, "Пётр");
        ChatUser u3 = new SimpleChatUser(chat, "Алексей");
        u2.setEnable(false);

        chat.setAdmin(admin);
        chat.addChatUser(u1);
        chat.addChatUser(u2);
        chat.addChatUser(u3);

        u1.sendMessage("Привет!");
        admin.sendMessage("Привет!");

    }
}

abstract class ChatUser {
    private Chat chat;
    private String name;
    private boolean isEnable = true;

    boolean isEnable() {
        return isEnable;
    }

    void setEnable(boolean enable) {
        this.isEnable = enable;
    }

    ChatUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    String getName() {
        return name;
    }

    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);

    @Override
    public String toString() {
        return "ChatUser{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Admin extends ChatUser {
    Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Администратор " + getName() + " получает сообщение \"" + message + "\"");
    }
}

class SimpleChatUser extends ChatUser {
    SimpleChatUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Пользователь " + getName() + " получает сообщение \"" + message + "\"");
    }
}

interface Chat {
    void sendMessage(String message, ChatUser ChatUser);
}

class TextChat implements Chat {
    private ChatUser admin;
    private List<ChatUser> ChatUserList = new ArrayList<>();

    void setAdmin(ChatUser admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        } else {
            throw new RuntimeException("Не хватает прав");
        }
    }

    void addChatUser(ChatUser u) {
        if (admin == null) {
            throw new RuntimeException("В чате не хватает админа");
        }
        if (u instanceof SimpleChatUser) {
            ChatUserList.add(u);
        } else {
            throw new RuntimeException("Админ не может входить в другой чат");
        }
    }

    @Override
    public void sendMessage(String message, ChatUser ChatUser) {
        if (ChatUser instanceof Admin) {
            for (ChatUser u : ChatUserList) {
                u.getMessage(ChatUser.getName() + ": " + message);
            }
        }
        if (ChatUser instanceof SimpleChatUser) {
            for (ChatUser u : ChatUserList) {
                if (u != ChatUser && u.isEnable()) {
                    u.getMessage(ChatUser.getName() + ": " + message);
                }
            }
            if (admin.isEnable()) {
                admin.getMessage(ChatUser.getName() + ": " + message);
            }
        }
    }
}
