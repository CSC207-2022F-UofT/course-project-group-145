package user_use_case;

import user.UserRequestModel;

import java.io.IOException;

public interface AddChatIdToMapInputBoundary {
    public void addChatId(int chatId, UserRequestModel requestModel) throws IOException;
}
