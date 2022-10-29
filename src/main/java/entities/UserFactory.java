package entities;

// Entity layer

import java.util.List;

public class UserFactory {
    User create(String username, String password, String email, List<Integer> chats, List<Integer> feeds) {
        return new User(username, password, email, chats, feeds);
    };
}