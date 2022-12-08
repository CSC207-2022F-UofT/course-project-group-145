package entities;

import java.util.List;

/**
 * Entity representing a chat between 2 users
 */
public class Chat {

    private static int numChat = 0;

    private int chatId;

    private List<Integer> messageIds;

    private boolean isDeleted;

    /**
     * Creates a new chat entity
     * @param messageIds list of ids of messages in this chat
     */
    Chat(List<Integer> messageIds) {
        this.chatId = numChat;
        this.messageIds = messageIds;
        this.isDeleted = false;
        numChat = numChat + 1;
    }

    public static int getNumChat() {
        return numChat;
    }

    public static void setNumChat(int numChat) {
        Chat.numChat = numChat;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public List<Integer> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<Integer> messageIds) {
        this.messageIds = messageIds;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * Returns true or false if the message has been added to chat
     *
     * @param messageId the id of the message
     * @return          boolean of whether it has been added successfully
     */
    public boolean addMessage(int messageId) {
        return this.messageIds.add(messageId);
    }

    /**
     * Returns true or false if the message has been deleted from chat
     *
     * @param messageId the id of the message
     * @return          boolean of whether it has been deleted successfully
     */
    public boolean deleteMessage(int messageId) {
        return this.messageIds.remove((Integer)messageId);
    }
}
