package use_cases.chat_list_use_cases;

import java.io.IOException;

public interface OpenChatInputBoundary {
    void openChat (int chatId, int userId, int otherUserId) throws IOException;
}
