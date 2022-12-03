package ui;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatResponseModel;
import controller_presenter_gateway.chat_controller_presenter_gateway.MessageRepoRequestModel;

import java.io.IOException;
import java.util.List;

public interface ChatListViewInterface {
    void delete(int userId, int chatId, int otherUserId, int i) throws IOException;

    void openChat(int userId, int chatId, int otherUserId) throws IOException;

    void failView(String message);

}
