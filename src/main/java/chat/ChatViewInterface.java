package chat;

import java.util.List;

public interface ChatViewInterface {

    void addMessage(ChatResponseModel responseModel);

    void deleteMessage(int messageId);

    void openChat(int chatId, int userId, int otherUser, List<MessageRepoRequestModel> messages);

    void addReply(ChatResponseModel responseModel, int replyToId);

}
