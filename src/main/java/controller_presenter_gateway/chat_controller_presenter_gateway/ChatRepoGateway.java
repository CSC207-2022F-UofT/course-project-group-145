package controller_presenter_gateway.chat_controller_presenter_gateway;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ChatRepoGateway {

    void delete(int chatId) throws IOException;

    int getNumChats();

    void addMessage(int chatId, int messageId) throws IOException;

    void save(ChatRepoRequestModel requestModel) throws IOException;

    Map<Integer, ChatRepoRequestModel> getAllChats();

    List<Integer> getMessagesOfChat(int chatId);
}
