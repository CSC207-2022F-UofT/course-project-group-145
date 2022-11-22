package chat;

import java.util.List;

public interface ChatViewInterface {
    void addMessages(List<MessageRepoRequestModel> messages);

    void addMessage(ChatResponseModel responseModel);
}
