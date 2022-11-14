package entities;

import java.util.Date;

public class MessageFactory {

    public Message create(String content, Date sendTime, int authorId, int receiverId) {
        return new Message(content, sendTime, authorId, receiverId);
    }
}
