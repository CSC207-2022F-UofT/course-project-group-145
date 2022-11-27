package chat;

public interface ChatOutputBoundary {

    void addMessage(ChatResponseModel responseModel);

    void deleteMessage(int messageId);

    void failView(String error);

    void openChat(int chatId, int userId, int otherUser);
}
