package chat_use_case;

import chat.ChatOutputBoundary;
import chat.MessageRepoGateway;

import java.io.IOException;

public class DeleteMessage implements DeleteMessageInputBoundary{

    private final ChatOutputBoundary chatOutputBoundary;

    private final MessageRepoGateway messageRepoGateway;

    public DeleteMessage(ChatOutputBoundary chatOutputBoundary, MessageRepoGateway messageRepoGateway) {
        this.chatOutputBoundary = chatOutputBoundary;
        this.messageRepoGateway = messageRepoGateway;
    }

    /**
     * Calls the gateway to delete a message by id and then calls the output boundary to prepare the UI to present
     *
     * @param messageId the id of the message being deleted
     */
    @Override
    public void delete(int messageId) throws IOException {
        messageRepoGateway.delete(messageId);
        // TODO: add success view
        // chatOutputBoundary.successView();
    }
}
