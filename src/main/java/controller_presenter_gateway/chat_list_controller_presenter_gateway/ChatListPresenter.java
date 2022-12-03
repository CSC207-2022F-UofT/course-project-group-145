package controller_presenter_gateway.chat_list_controller_presenter_gateway;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepoGateway;
import ui.ChatListViewInterface;

import java.util.List;

public class ChatListPresenter implements ChatDeletionOutputBoundary {

    private final ChatListViewInterface chatListViewInterface;

    private final ChatRepoGateway chatRepoGateway;

    public ChatListPresenter(ChatListViewInterface chatListViewInterface, ChatRepoGateway chatRepoGateway) {
        this.chatListViewInterface = chatListViewInterface;
        this.chatRepoGateway = chatRepoGateway;
    }

    @Override
    public void successView(ChatDeletionResponseModel responseModel) {

    }

    /**
     * Passes the error to the view to display tell the user that an error occurred
     *
     * @param error the error message
     */
    @Override
    public void failView(String error){
        chatListViewInterface.failView(error);
    }
}


