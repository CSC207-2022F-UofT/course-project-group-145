package use_cases.chat_use_cases;

import java.io.IOException;

public interface DeleteChatInputBoundary {
    void delete(int chatId) throws IOException;
}