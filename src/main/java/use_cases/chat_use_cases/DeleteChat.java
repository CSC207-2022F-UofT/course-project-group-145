package use_cases.chat_use_cases;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepoGateway;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionOutputBoundary;

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
    }
}