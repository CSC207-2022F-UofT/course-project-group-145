package chat;

import java.util.List;

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

    /**
     * Passes the message to be added onto the view to add to UI
     *
     * @param responseModel the response model containing the message to be added to the view
     */
    @Override
    public void addMessage(ChatResponseModel responseModel){
        chatViewInterface.addMessage(responseModel);

    }

    @Override
    public void deleteMessage(int messageId) {
        chatViewInterface.deleteMessage(messageId);
    }

    @Override
    public void replyMessage(ChatResponseModel responseModel, int replyToId) {
        chatViewInterface.addReply(responseModel, replyToId);
    }

    @Override
    public void editMessage(int messageId, String content){
        chatViewInterface.editMessage(messageId, content);
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
