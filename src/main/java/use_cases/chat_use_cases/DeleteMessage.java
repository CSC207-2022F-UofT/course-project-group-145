package use_cases.chat_use_cases;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatOutputBoundary;
import controller_presenter_gateway.chat_controller_presenter_gateway.MessageRepoGateway;

import java.io.IOException;

public class DeleteMessage implements DeleteMessageInputBoundary{

    private final ChatOutputBoundary chatOutputBoundary;

    private final MessageRepoGateway messageRepoGateway;

    /**
     * Creates use case with given interfaces
     *
     * @param chatOutputBoundary the output boundary
     * @param messageRepoGateway the message repository gateway
     */
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
    public void delete(int messageId){
        try{
            messageRepoGateway.delete(messageId);
            chatOutputBoundary.deleteMessage(messageId);
        } catch (IOException e) {
            chatOutputBoundary.failView("Message failed to delete");
        }
    }
}
