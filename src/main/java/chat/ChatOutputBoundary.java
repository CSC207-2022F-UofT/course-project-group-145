package chat;

public interface ChatOutputBoundary {

    void successView(ChatResponseModel responseModel);

    void failView(String error);
}
