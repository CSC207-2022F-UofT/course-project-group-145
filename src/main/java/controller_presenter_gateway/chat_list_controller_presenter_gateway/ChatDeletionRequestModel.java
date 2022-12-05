package controller_presenter_gateway.chat_list_controller_presenter_gateway;

public class ChatDeletionRequestModel {
    private int chatId;

    public ChatDeletionRequestModel(int chatId) {
        this.chatId = chatId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }
}