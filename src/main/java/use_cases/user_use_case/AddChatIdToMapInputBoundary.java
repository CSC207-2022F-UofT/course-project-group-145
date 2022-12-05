package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserRequestModel;

import java.io.IOException;

public interface AddChatIdToMapInputBoundary {
    void addChatId(int chatId, UserRequestModel requestModel) throws IOException;
}
