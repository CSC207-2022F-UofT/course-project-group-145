package chatUseCases;

import java.io.IOException;

public interface DeleteChatInputBoundary {
    void delete(int chatId) throws IOException;
}