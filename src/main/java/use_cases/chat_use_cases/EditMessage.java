package use_cases.chat_use_cases;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatOutputBoundary;
import controller_presenter_gateway.chat_controller_presenter_gateway.MessageRepoGateway;

import java.io.IOException;

public class EditMessage implements EditMessageInputBoundary {

    private final ChatOutputBoundary chatOutputBoundary;

    private final MessageRepoGateway messageRepoGateway;

    /**
     * Creates the use case with the given interfaces
     *
     * @param chatOutputBoundary the output boundary
     * @param messageRepoGateway the message repository gateway
     */
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
    public void edit(int messageId, String content) {
        try{
            messageRepoGateway.edit(messageId, content);
            chatOutputBoundary.editMessage(messageId, content);
        } catch (IOException e) {
            chatOutputBoundary.failView("Message failed to edit");
        }
    }
}
