package chat_for_deletion;

public interface ChatDeletionOutputBoundary {
    void successView(ChatDeletionResponseModel responseModel);

    void failView(String error);
}
