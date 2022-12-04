package controller_presenter_gateway.chat_list_controller_presenter_gateway;

import use_cases.chat_list_use_cases.DeleteChatInputBoundary;
import use_cases.chat_list_use_cases.OpenChatInputBoundary;

import java.io.IOException;

public class ChatListController {
    private final DeleteChatInputBoundary deleteChatInputBoundary;
    private final OpenChatInputBoundary openChatInputBoundary;

    public ChatListController(DeleteChatInputBoundary deleteChatInputBoundary,
                              OpenChatInputBoundary openChatInputBoundary) {
        this.deleteChatInputBoundary = deleteChatInputBoundary;
        this.openChatInputBoundary = openChatInputBoundary;
    }

    public void openChat(int chatId, int userId, int otherUserId) throws IOException {
        this.openChatInputBoundary.openChat(chatId, userId, otherUserId);
    }

    public void delete(int chatId) throws IOException {
        this.deleteChatInputBoundary.delete(chatId);
    }
}
