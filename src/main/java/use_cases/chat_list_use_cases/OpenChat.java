package use_cases.chat_list_use_cases;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatOutputBoundary;

import java.io.IOException;

/**
 * Use case for opening a chat and displaying it to user
 */
public class OpenChat implements OpenChatInputBoundary {
    private final ChatOutputBoundary chatOutputBoundary;

    /**
     * Creates a new OpeenChat use case
     * @param chatOutputBoundary instance of presenter to update
     */
    public OpenChat (ChatOutputBoundary chatOutputBoundary) {
        this.chatOutputBoundary = chatOutputBoundary;
    }

    /**
     * Calls the presenter to open an existing chat
     *
     * @param chatId the id of the chat being opened
     * @param userId the id of the user opening the chat
     * @param otherUserId the id of the other user in the chat
     */
    @Override
    public void openChat(int chatId, int userId, int otherUserId) throws IOException {
        chatOutputBoundary.openChat(chatId, userId, otherUserId);
        }
}

