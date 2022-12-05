package controller_presenter_gateway.chat_list_controller_presenter_gateway;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepoGateway;
import ui.ChatListViewInterface;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChatListPresenter implements ChatDeletionOutputBoundary {

    private final ChatListViewInterface chatListViewInterface;

    private final ChatRepoGateway chatRepoGateway;
    private final UserRepoGateway userRepoGateway;

    public ChatListPresenter(ChatListViewInterface chatListViewInterface, ChatRepoGateway chatRepoGateway,
                             UserRepoGateway userRepoGateway) {
        this.chatListViewInterface = chatListViewInterface;
        this.chatRepoGateway = chatRepoGateway;
        this.userRepoGateway = userRepoGateway;
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


    @Override
    public void openChatList(int userId) throws IOException {
        //call the User repository
        UserRepoRequestModel u = userRepoGateway.getUser(userId);
        List<Integer> chatIds = new ArrayList<>(u.getListOfChatIds().keySet());
        Map<Integer, Integer> chatToUser = u.getListOfChatIds();
        for(int id: chatIds) {
            if (chatRepoGateway.getAllChats().get(id).isDeleted()) {
               chatToUser.remove(id);
            }
        }
        this.chatListViewInterface.openChatList(userId, chatToUser);
    }
}


