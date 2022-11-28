package chat;

import chat_use_case.DeleteMessageInputBoundary;
import chat_use_case.EditMessageInputBoundary;
import chat_use_case.SendMessageInputBoundary;

import java.io.IOException;
import java.util.Date;

public class ChatController {
    private final DeleteMessageInputBoundary deleteMessageInputBoundary;

    private final EditMessageInputBoundary editMessageInputBoundary;

    private final SendMessageInputBoundary sendMessageInputBoundary;

    public ChatController(DeleteMessageInputBoundary deleteMessageInputBoundary,
                          EditMessageInputBoundary editMessageInputBoundary,
                          SendMessageInputBoundary sendMessageInputBoundary) {
        this.deleteMessageInputBoundary = deleteMessageInputBoundary;
        this.editMessageInputBoundary = editMessageInputBoundary;
        this.sendMessageInputBoundary = sendMessageInputBoundary;
    }

    public void sendMessage(int chatId, String content, int sender, int receiver) throws IOException {
        ChatRequestModel requestModel = new ChatRequestModel(chatId, content, sender, receiver, new Date());
        this.sendMessageInputBoundary.send(requestModel);
    }

    public void deleteMessage(int messageId) throws IOException{
        this.deleteMessageInputBoundary.delete(messageId);
    }

    public void editMessage(int messageId, String content) throws IOException{
        this.editMessageInputBoundary.edit(messageId, content);
    }

    public void replyMessage(int chatId, String content, int sender, int receiver, int replyToId) throws IOException {
        ChatRequestModel requestModel = new ChatRequestModel(chatId, content, sender, receiver, new Date());
        this.sendMessageInputBoundary.reply(requestModel, replyToId);
    }
}
