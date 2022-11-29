package chat_use_case;

import chat.ChatOutputBoundary;

import java.io.IOException;

public class OpenChat implements OpenChatInputBoundary {
    private final ChatOutputBoundary chatOutputBoundary;

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

