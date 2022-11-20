package chat_use_case;

import chat.*;
import entities.Message;
import entities.MessageFactory;

import java.io.IOException;

public class SendMessage implements SendMessageInputBoundary {

    private final MessageFactory messageFactory;

    private final ChatOutputBoundary chatOutputBoundary;

    private final MessageRepoGateway messageRepoGateway;

    private final ChatRepoGateway chatRepoGateway;

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
    public void send(ChatRequestModel requestModel) throws IOException {
        MessageRepoRequestModel messageRepoRequestModel = getMessageRepoRequestModel(requestModel);
        messageRepoGateway.save(messageRepoRequestModel);
        chatRepoGateway.addMessage(requestModel.getChatId(), messageRepoRequestModel.getMessageId());
        // TODO: add success view

        // chatOutputBoundary.successView();
    }

    /**
     * Creates a message that is a reply to another message that will be saved to the chat. It is then saved
     * to persistence by calling the gateway. It will then call the output boundary so UI will eventually update
     *
     * @param requestModel the request model created from controller with chat id and message
     * @param replyToMessageId the id of the message that the requestModel message is replying to
     */
    @Override
    public void reply(ChatRequestModel requestModel, int replyToMessageId) throws IOException {
        MessageRepoRequestModel messageRepoRequestModel = getMessageRepoRequestModel(requestModel);
        messageRepoGateway.addReply(messageRepoRequestModel, replyToMessageId);
        chatRepoGateway.addMessage(requestModel.getChatId(), messageRepoRequestModel.getMessageId());
        // TODO: add success view

        // move to another use case called replymessage or something

        // chatOutputBoundary.successView();
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
