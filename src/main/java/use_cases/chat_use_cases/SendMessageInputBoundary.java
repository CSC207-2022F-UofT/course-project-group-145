package use_cases.chat_use_cases;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRequestModel;

public interface SendMessageInputBoundary {
    void send(ChatRequestModel requestModel);

    void reply(ChatRequestModel requestModel, int messageId);
}
