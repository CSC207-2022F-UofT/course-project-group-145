package use_cases.chat_use_cases;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatOutputBoundary;
import controller_presenter_gateway.chat_controller_presenter_gateway.MessageRepoGateway;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepoGateway;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRequestModel;
import controller_presenter_gateway.chat_controller_presenter_gateway.MessageRepoRequestModel;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatResponseModel;
import entities.Message;
import entities.MessageFactory;

import java.io.IOException;

public class SendMessage implements SendMessageInputBoundary {

    private final MessageFactory messageFactory;

    private final ChatOutputBoundary chatOutputBoundary;

    private final MessageRepoGateway messageRepoGateway;

    private final ChatRepoGateway chatRepoGateway;

    /**
     * Creates the use case with the given factory and interfaces
     *
     * @param messageFactory the message factory
     * @param chatOutputBoundary the output boundary
     * @param messageRepoGateway the message repository gateway
     * @param chatRepoGateway the chat repository gateway
     */
    public SendMessage(MessageFactory messageFactory, ChatOutputBoundary chatOutputBoundary,
                       MessageRepoGateway messageRepoGateway, ChatRepoGateway chatRepoGateway) {
        this.messageFactory = messageFactory;
        this.chatOutputBoundary = chatOutputBoundary;
        this.chatRepoGateway = chatRepoGateway;
        this.messageRepoGateway = messageRepoGateway;
    }

    /**
     * Creates a message that will be saved to the chat. It is then saved
     * to persistence by calling the gateway. It will then call the output boundary so UI will eventually update
     *
     * @param requestModel the request model created from controller with chat id and message
     */
    @Override
    public void send(ChatRequestModel requestModel) {
        try {
            MessageRepoRequestModel messageRepoRequestModel = getMessageRepoRequestModel(requestModel);
            messageRepoGateway.save(messageRepoRequestModel);
            chatRepoGateway.addMessage(requestModel.getChatId(), messageRepoRequestModel.getMessageId());
            ChatResponseModel responseModel = new ChatResponseModel(messageRepoRequestModel.getMessageId(),
                    messageRepoRequestModel.getContent(), messageRepoRequestModel.getAuthor(),
                    messageRepoRequestModel.getReceiver(), messageRepoRequestModel.getSendTime());

            chatOutputBoundary.addMessage(responseModel);
        } catch (IOException e) {
            chatOutputBoundary.failView("Message failed to send");
        }
    }

    /**
     * Creates a message that is a reply to another message that will be saved to the chat. It is then saved
     * to persistence by calling the gateway. It will then call the output boundary so UI will eventually update
     *
     * @param requestModel the request model created from controller with chat id and message
     * @param replyToMessageId the id of the message that the requestModel message is replying to
     */
    @Override
    public void reply(ChatRequestModel requestModel, int replyToMessageId) {
        try {
            MessageRepoRequestModel messageRepoRequestModel = getMessageRepoRequestModel(requestModel);
            messageRepoGateway.addReply(messageRepoRequestModel, replyToMessageId);
            chatRepoGateway.addMessage(requestModel.getChatId(), messageRepoRequestModel.getMessageId());

            ChatResponseModel responseModel = new ChatResponseModel(messageRepoRequestModel.getMessageId(),
                    messageRepoRequestModel.getContent(), messageRepoRequestModel.getAuthor(),
                    messageRepoRequestModel.getReceiver(), messageRepoRequestModel.getSendTime());

            chatOutputBoundary.replyMessage(responseModel, replyToMessageId);
        } catch (IOException e) {
            chatOutputBoundary.failView("Message failed to reply");
        }
    }

    private MessageRepoRequestModel getMessageRepoRequestModel(ChatRequestModel requestModel) {
        Message.setNumMessages(messageRepoGateway.getNumMessages());
        Message message = messageFactory.create(requestModel.getContent(), requestModel.getSendTime(),
                requestModel.getAuthor(), requestModel.getReceiver());
        return new MessageRepoRequestModel(message.getMessageId(),
                message.getContent(), message.getAuthor(), message.getReceiver(), message.getSendTime(),
                message.getLastEditTime(), message.isMessageSeen(), message.isDeleted(), message.isEdited(),
                message.getReplyId());
    }
}
