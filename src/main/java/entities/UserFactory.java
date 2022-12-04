package entities;

import java.util.List;
import java.util.Map;

public class UserFactory {
    public User create(String username, String password, String email, Map<Integer, Integer> chats, List<Integer> feeds) {
        return new User(username, password, email, chats, feeds);
    }
}