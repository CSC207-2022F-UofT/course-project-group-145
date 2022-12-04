package chat;

import java.io.IOException;
import java.util.Map;

public interface ChatRepoGateway {

    void delete(int chatId) throws IOException;

    int getNumChats();

    void addMessage(int chatId, int messageId) throws IOException;

    void save(ChatRepoRequestModel requestModel) throws IOException;

    Map<Integer, ChatRepoRequestModel> getAllChats();
}
