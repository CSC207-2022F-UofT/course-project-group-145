package use_cases.homepage_use_cases;

import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionOutputBoundary;

import java.io.IOException;

public class OpenChatList implements OpenChatListInputBoundary {

    private final ChatDeletionOutputBoundary deletionOutputBoundary;

    /**
     * Create the open chat list use case
     *
     * @param deletionOutputBoundary the chat list output boundary
     */
    public OpenChatList(ChatDeletionOutputBoundary deletionOutputBoundary) {
        this.deletionOutputBoundary = deletionOutputBoundary;
    }

    /**
     * Calls output boundary to open the chat list of current user
     *
     * @param userId the user id of the current user
     */
    @Override
    public void openList(int userId) throws IOException {
        deletionOutputBoundary.openChatList(userId);
    }
}
