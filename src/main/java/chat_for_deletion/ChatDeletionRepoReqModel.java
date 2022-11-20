package chat_for_deletion;

import java.util.List;

public class ChatDeletionRepoReqModel {
    private int chatId;
    private List<Integer> messageIds;
    private boolean isDeleted;

    public ChatDeletionRepoReqModel(int chatId, List<Integer> messageIds, boolean isDeleted) {
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