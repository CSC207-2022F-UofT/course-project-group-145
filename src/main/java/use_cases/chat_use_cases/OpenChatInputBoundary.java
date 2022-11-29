package chat_use_case;

import java.io.IOException;

public interface OpenChatInputBoundary {
    void openChat (int chatId, int userId, int otherUserId) throws IOException;
}
