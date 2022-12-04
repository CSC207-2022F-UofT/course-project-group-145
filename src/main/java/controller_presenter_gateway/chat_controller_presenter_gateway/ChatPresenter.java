package controller_presenter_gateway.chat_controller_presenter_gateway;

import ui.ChatViewInterface;

import java.util.List;

public class ChatPresenter implements ChatOutputBoundary {

    private final ChatViewInterface chatViewInterface;

    private final ChatRepoGateway chatRepoGateway;

    private final MessageRepoGateway messageRepoGateway;

    /**
     * Create a ChatPresenter with the given interfaces
     *
     * @param chatViewInterface the view interface
     * @param chatRepoGateway the chat repository interface
     * @param messageRepoGateway the message repository interface
     */
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

    /**
     * Passes the messageId to be deleted to the view so the view may remove it
     *
     * @param messageId the message being deleted
     */
    @Override
    public void deleteMessage(int messageId) {
        chatViewInterface.deleteMessage(messageId);
    }

    /**
     * Passes the reply message and the id of the message to be replied to to the view to add it to the view
     *
     * @param responseModel the reply message
     * @param replyToId the message that is being replied to
     */
    @Override
    public void replyMessage(ChatResponseModel responseModel, int replyToId) {
        chatViewInterface.addReply(responseModel, replyToId);
    }

    /**
     * Passes the edited contents of the message and the id of the message being edited to the view to change the view
     *
     * @param messageId the message being edited
     * @param content the changed contents
     */
    @Override
    public void editMessage(int messageId, String content){
        chatViewInterface.editMessage(messageId, content);
    }

    /**
     * Passes the error to the view to display tell the user that an error occurred
     *
     * @param error the error message
     */
    @Override
    public void failView(String error){
        chatViewInterface.failView(error);
    }

    /**
     * Gets the messages from the repository of the specific chat and passes those messages and user ids along to
     * view so the view can properly display the opened chat
     *
     * @param chatId the chat to be opened
     * @param userId the current user
     * @param otherUser the other user in the chat
     */
    @Override
    public void openChat(int chatId, int userId, int otherUser) {
        List<Integer> messageIds = this.chatRepoGateway.getMessagesOfChat(chatId);
        List<MessageRepoRequestModel> messages = this.messageRepoGateway.getMessages(messageIds);
        chatViewInterface.openChat(chatId, userId, otherUser, messages);
    }
}
