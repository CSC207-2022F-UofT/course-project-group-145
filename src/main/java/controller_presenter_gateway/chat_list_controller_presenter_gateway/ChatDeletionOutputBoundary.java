package controller_presenter_gateway.chat_list_controller_presenter_gateway;

public interface ChatDeletionOutputBoundary {
    void successView(ChatDeletionResponseModel responseModel);

    void openListChat(int userId);

    void failView(String error);
}
