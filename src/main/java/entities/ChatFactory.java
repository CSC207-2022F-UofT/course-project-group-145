package entities;

import java.util.List;

/**
 * Factory that creates chat entities
 */
public class ChatFactory {

    /**
     * Create a chat
     *
     * @param messageIds the list of ids of messages in the chat
     * @return a chat with given messageIds
     */
    public Chat create(List<Integer> messageIds) {
        return new Chat(messageIds);
    }
}
