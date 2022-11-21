package chat_use_case;

import chat.ChatOutputBoundary;
import chat.ChatRequestModel;
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
     * @param requestModel the request model created from controller with the message being edited
     */
    @Override
    public void edit(int messageId, ChatRequestModel requestModel) throws IOException {
        messageRepoGateway.edit(messageId, requestModel.getContent());

        // TODO: prepare success view
    }
}
