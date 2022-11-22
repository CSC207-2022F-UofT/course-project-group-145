package chat_use_case;

import chat.ChatRepoGateway;
import chat_for_deletion.ChatDeletionOutputBoundary;

import java.io.IOException;

public class DeleteChat implements DeleteChatInputBoundary {
    private final ChatDeletionOutputBoundary chatDeletionOutputBoundary;
    private final ChatRepoGateway chatRepoGateway;

    public DeleteChat(ChatDeletionOutputBoundary chatDeletionOutputBoundary, ChatRepoGateway chatRepoGateway) {
        this.chatDeletionOutputBoundary = chatDeletionOutputBoundary;
        this.chatRepoGateway = chatRepoGateway;
    }

    /**
     * Calls the gateway to delete a chat by chatId and then calls the output boundary to prepare the UI to present
     *
     * @param chatId the id of the chat being deleted
     */
    @Override
    public void delete(int chatId) throws IOException {
        chatRepoGateway.delete(chatId);
        // TODO: add success view
        // chatOutputBoundary.successView();
    }
}