package entities;

import java.util.List;

public class ChatFactory {

    public Chat create(List<Integer> messageIds) {
        return new Chat(messageIds);
    }
}
