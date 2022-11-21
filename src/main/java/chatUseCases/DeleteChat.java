package chatUseCases;

import chat_for_deletion.ChatDeletionOutputBoundary;
import chat_for_deletion.ChatDeletionGateway;

import java.io.IOException;

public class DeleteChat implements DeleteChatInputBoundary {
    private final ChatDeletionOutputBoundary chatDeletionOutputBoundary;
    private final ChatDeletionGateway chatDeletionGateway;

    public DeleteChat(ChatDeletionOutputBoundary chatDeletionOutputBoundary, ChatDeletionGateway chatDeletionGateway) {
        this.chatDeletionOutputBoundary = chatDeletionOutputBoundary;
        this.chatDeletionGateway = chatDeletionGateway;
    }

    /**
     * Calls the gateway to delete a chat by chatId and then calls the output boundary to prepare the UI to present
     *
     * @param chatId the id of the chat being deleted
     */
    @Override
    public void delete(int chatId) throws IOException {
        chatDeletionGateway.delete(chatId);
        // TODO: add success view
        // chatOutputBoundary.successView();
    }
}