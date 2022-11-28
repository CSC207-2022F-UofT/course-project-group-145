package chat;

public interface ChatOutputBoundary {

    void addMessage(ChatResponseModel responseModel);

    void deleteMessage(int messageId);

    void replyMessage(ChatResponseModel responseModel, int replyToId);

    void editMessage(int messageId, String content);

    void failView(String error);

    void openChat(int chatId, int userId, int otherUser);
}
