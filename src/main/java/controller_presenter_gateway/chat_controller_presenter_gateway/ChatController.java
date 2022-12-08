package controller_presenter_gateway.chat_controller_presenter_gateway;

import use_cases.chat_use_cases.DeleteMessageInputBoundary;
import use_cases.chat_use_cases.EditMessageInputBoundary;
import use_cases.chat_use_cases.SendMessageInputBoundary;
import use_cases.homepage_use_cases.OpenHomePageInputBoundary;

import java.util.Date;

/**
 * Controller used for controlling chat-related use cases
 */
public class ChatController {
    private final DeleteMessageInputBoundary deleteMessageInputBoundary;

    private final EditMessageInputBoundary editMessageInputBoundary;

    private final SendMessageInputBoundary sendMessageInputBoundary;

    private final OpenHomePageInputBoundary openHomePageInputBoundary;

    /**
     * Create a ChatController with given input boundaries
     *
     * @param deleteMessageInputBoundary for deleting a chat
     * @param editMessageInputBoundary for editing a chat
     * @param sendMessageInputBoundary for sending a message or replying to a message
     * @param openHomePageInputBoundary for opening the home page
     */
    public ChatController(DeleteMessageInputBoundary deleteMessageInputBoundary,
                          EditMessageInputBoundary editMessageInputBoundary,
                          SendMessageInputBoundary sendMessageInputBoundary,
                          OpenHomePageInputBoundary openHomePageInputBoundary) {
        this.deleteMessageInputBoundary = deleteMessageInputBoundary;
        this.editMessageInputBoundary = editMessageInputBoundary;
        this.sendMessageInputBoundary = sendMessageInputBoundary;
        this.openHomePageInputBoundary = openHomePageInputBoundary;
    }

    /**
     * Send the input data into the send message use case to send a message
     *
     * @param chatId the chat id
     * @param content the message content being sent
     * @param sender the sender id
     * @param receiver the receiver id
     */
    public void sendMessage(int chatId, String content, int sender, int receiver) {
        ChatRequestModel requestModel = new ChatRequestModel(chatId, content, sender, receiver, new Date());
        this.sendMessageInputBoundary.send(requestModel);
    }

    /**
     * Sends the message id of the message to be deleted into the use case to delete the message
     *
     * @param messageId the message id
     */
    public void deleteMessage(int messageId) {
        this.deleteMessageInputBoundary.delete(messageId);
    }

    /**
     * Sends the input data into the edit message use case to edit the message
     *
     * @param messageId the message id
     * @param content the changed message content
     */
    public void editMessage(int messageId, String content) {
        this.editMessageInputBoundary.edit(messageId, content);
    }

    /**
     * Sends the input data into the send message use case to reply to a message
     *
     * @param chatId the chat id
     * @param content the message contents
     * @param sender the sender id
     * @param receiver the receiver id
     * @param replyToId the message id of the message being replied to
     */
    public void replyMessage(int chatId, String content, int sender, int receiver, int replyToId) {
        ChatRequestModel requestModel = new ChatRequestModel(chatId, content, sender, receiver, new Date());
        this.sendMessageInputBoundary.reply(requestModel, replyToId);
    }

    /**
     * Move to the homepage
     *
     * @param userId the current user id
     */
    public void goToHome(int userId) {
        this.openHomePageInputBoundary.openHome(userId);
    }
}
