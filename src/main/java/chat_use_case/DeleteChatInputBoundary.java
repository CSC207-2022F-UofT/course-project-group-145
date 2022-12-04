package chat_use_case;

import java.io.IOException;

public interface DeleteChatInputBoundary {
    void delete(int chatId) throws IOException;
}