package controller_presenter_gateway.chat_list_controller_presenter_gateway;

import java.io.IOException;

public interface ChatDeletionOutputBoundary {
    void successView(ChatDeletionResponseModel responseModel);

    void openChatList(int userId) throws IOException;

    void failView(String error);
}
