package chat;

import java.util.List;
import java.util.Map;

public class ChatPresenter implements ChatOutputBoundary{

    private final ChatViewInterface chatViewInterface;

    private final ChatRepoGateway chatRepoGateway;

    private final MessageRepoGateway messageRepoGateway;

    public ChatPresenter(ChatViewInterface chatViewInterface, ChatRepoGateway chatRepoGateway,
                         MessageRepoGateway messageRepoGateway) {
        this.chatViewInterface = chatViewInterface;
        this.chatRepoGateway = chatRepoGateway;
        this.messageRepoGateway = messageRepoGateway;
    }

    @Override
    public void addMessage(ChatResponseModel responseModel){
        chatViewInterface.addMessage(responseModel);

    }

    @Override
    public void deleteMessage(int messageId) {
        chatViewInterface.deleteMessage(messageId);
    }

    @Override
    public void failView(String error){

    }

    @Override
    public void openChat(int chatId, int userId, int otherUser) {
        List<Integer> messageIds = this.chatRepoGateway.getMessagesOfChat(chatId);
        List<MessageRepoRequestModel> messages = this.messageRepoGateway.getMessages(messageIds);
        this.chatViewInterface.openChat(chatId, userId, otherUser, messages);
    }
}
