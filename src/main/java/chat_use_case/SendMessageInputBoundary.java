package chat_use_case;

import chat.ChatRequestModel;

import java.io.IOException;

public interface SendMessageInputBoundary {
    void send(ChatRequestModel requestModel) throws IOException;

    void reply(ChatRequestModel requestModel, int messageId) throws IOException;
}
