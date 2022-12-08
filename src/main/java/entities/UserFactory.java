package entities;

import java.util.List;
import java.util.Map;

/**
 * Factory object for creating new user instances
 */
public class UserFactory {
    /**
     * Creates a new user
     * @param username username of user
     * @param password password of user
     * @param email email of user
     * @param chats map object mapping id of chats of user with the id of other user in the chat
     * @param feeds list of ids of feeds this user owns
     * @return the created user entity
     */
    public User create(String username, String password, String email, Map<Integer, Integer> chats, List<Integer> feeds) {
        return new User(username, password, email, chats, feeds);
    }
}