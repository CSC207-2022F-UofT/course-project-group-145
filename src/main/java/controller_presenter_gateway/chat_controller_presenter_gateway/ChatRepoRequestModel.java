package controller_presenter_gateway.chat_controller_presenter_gateway;

import java.util.List;

/**
 * Request model for saving chat information to the ChatRepository
 */
public class ChatRepoRequestModel {

    private int chatId;

    private List<Integer> messageIds;

    private boolean isDeleted;

    /**
     * Constructor for creating a new ChatRepoRequestModel, used for passing information to ChatRepository
     * @param chatId id of the chat to be saved in the repo
     * @param messageIds list of the ids of each message in the chat
     * @param isDeleted boolean flag representing if this chat is deleted or not
     */
    public ChatRepoRequestModel(int chatId, List<Integer> messageIds, boolean isDeleted) {
        this.chatId = chatId;
        this.messageIds = messageIds;
        this.isDeleted = isDeleted;
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
}
