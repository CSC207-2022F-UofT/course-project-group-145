package controller_presenter_gateway.chat_controller_presenter_gateway;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MessageRepoGateway {

    void save(MessageRepoRequestModel requestModel) throws IOException;

    void delete(int messageId) throws IOException;

    void edit(int messageId, String content) throws IOException;

    void addReply(MessageRepoRequestModel reply, int replyToMessage) throws IOException;

    int getNumMessages();

    List<MessageRepoRequestModel> getMessages(List<Integer> messageIds);

    Map<Integer, MessageRepoRequestModel> getAllMessages();
}
