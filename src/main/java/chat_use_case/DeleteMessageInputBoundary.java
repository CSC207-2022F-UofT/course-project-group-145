package chat_use_case;

import java.io.IOException;

public interface DeleteMessageInputBoundary {

    void delete(int messageId) throws IOException;
}
