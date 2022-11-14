package chat;

import java.io.IOException;

public interface ChatRepoGateway {

    int getNumChats();

    void addMessage(int chatId, int messageId) throws IOException;

    void save(ChatRepoRequestModel requestModel) throws IOException;
}
