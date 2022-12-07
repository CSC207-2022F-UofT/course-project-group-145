package controller_presenter_gateway.chat_list_controller_presenter_gateway;

import use_cases.chat_list_use_cases.DeleteChatInputBoundary;
import use_cases.chat_list_use_cases.OpenChatInputBoundary;
import use_cases.homepage_use_cases.OpenHomePageInputBoundary;

import java.io.IOException;

public class ChatListController {
    private final DeleteChatInputBoundary deleteChatInputBoundary;
    private final OpenChatInputBoundary openChatInputBoundary;

    private final OpenHomePageInputBoundary openHomePageInputBoundary;

    public ChatListController(DeleteChatInputBoundary deleteChatInputBoundary,
                              OpenChatInputBoundary openChatInputBoundary,
                              OpenHomePageInputBoundary openHomePageInputBoundary) {
        this.deleteChatInputBoundary = deleteChatInputBoundary;
        this.openChatInputBoundary = openChatInputBoundary;
        this.openHomePageInputBoundary = openHomePageInputBoundary;
    }

    /**
     * Calls the OpenChatInputBoundary which calls the use case to open an existing chat in the Chat List View.
     *
     * @param chatId the id of the chat being opened
     * @param userId the id of the user opening the chat
     * @param otherUserId the id of the other user in the chat
     */
    public void openChat(int chatId, int userId, int otherUserId) throws IOException {
        this.openChatInputBoundary.openChat(chatId, userId, otherUserId);
    }

    /**
     * Calls the DeleteChatInputBoundary which calls the DeleteChat use case to delete a chat by chatId.
     *
     * @param chatId the id of the chat being deleted
     */
    public void delete(int chatId) throws IOException {
        this.deleteChatInputBoundary.delete(chatId);
    }

    /**
     * Opens the homepage
     *
     * @param userId of the user logged in.
     */
    public void openHomePage(int userId) {
        this.openHomePageInputBoundary.openHome(userId);
    }
}
