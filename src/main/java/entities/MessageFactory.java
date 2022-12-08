package entities;

import java.util.Date;

/**
 * Factory object that creates messages
 */
public class MessageFactory {

    /**
     * Create a message
     *
     * @param content the content of the message
     * @param sendTime the send time of the message
     * @param authorId the id of the author
     * @param receiverId the id of the receiver
     * @return a new message created from given content, send time, author, and receiver
     */
    public Message create(String content, Date sendTime, int authorId, int receiverId) {
        return new Message(content, sendTime, authorId, receiverId);
    }
}
