package use_cases.chat_list_use_cases;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepoGateway;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionOutputBoundary;

import java.io.IOException;

/**
 * Use case for deleting a chat
 */
public class DeleteChat implements DeleteChatInputBoundary {
    private final ChatDeletionOutputBoundary chatDeletionOutputBoundary;
    private final ChatRepoGateway chatRepoGateway;

    /**
     * Creates a new DeleteChat use case
     * @param chatDeletionOutputBoundary instance of the presenter for this use case to update
     * @param chatRepoGateway instance of the chat repository to send chat info to save to persistence
     */
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
    }
}