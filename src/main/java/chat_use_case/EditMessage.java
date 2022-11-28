package chat_use_case;

import chat.ChatOutputBoundary;
import chat.MessageRepoGateway;

import java.io.IOException;

public class EditMessage implements EditMessageInputBoundary {

    private final ChatOutputBoundary chatOutputBoundary;

    private final MessageRepoGateway messageRepoGateway;

    public EditMessage(ChatOutputBoundary chatOutputBoundary, MessageRepoGateway messageRepoGateway) {
        this.chatOutputBoundary = chatOutputBoundary;
        this.messageRepoGateway = messageRepoGateway;
    }

    /**
     * Calls the gateway to edit the message given the message id and request model and then calls
     * output boundary to prepare the UI to present
     *
     * @param messageId the id of the message being edited
     * @param content the message
     */
    @Override
    public void edit(int messageId, String content) throws IOException {
        messageRepoGateway.edit(messageId, content);

        chatOutputBoundary.editMessage(messageId, content);
    }
}
