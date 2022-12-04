package ui;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatResponseModel;
import controller_presenter_gateway.chat_controller_presenter_gateway.MessageRepoRequestModel;

import java.util.List;

public interface ChatViewInterface {

    void addMessage(ChatResponseModel responseModel);

    void deleteMessage(int messageId);

    void openChat(int chatId, int userId, int otherUser, List<MessageRepoRequestModel> messages);

    void addReply(ChatResponseModel responseModel, int replyToId);

    void editMessage(int messageId, String content);

    void failView(String message);

}
