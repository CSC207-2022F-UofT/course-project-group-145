package chat;

public class ChatPresenter implements ChatOutputBoundary{

    private final ChatViewInterface chatViewInterface;

    public ChatPresenter(ChatViewInterface chatViewInterface) {
        this.chatViewInterface = chatViewInterface;
    }

    @Override
    public void successView(ChatResponseModel responseModel){
        chatViewInterface.addMessage(responseModel);

    }

    @Override
    public void failView(String error){

    }

    public void openChat(int chatId) {

    }
}
