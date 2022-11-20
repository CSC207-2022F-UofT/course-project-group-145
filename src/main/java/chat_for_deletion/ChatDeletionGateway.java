package chat_for_deletion;

import java.io.IOException;

public interface ChatDeletionGateway {
    void delete(int chatId) throws IOException;
    void save(ChatDeletionRepoReqModel requestModel) throws IOException;
}