package user_use_case;

import user.UserRequestModel;

import java.io.IOException;

public interface AddFeedIdInputBoundary {

    public void addFeedId(int messageId, UserRequestModel requestModel) throws IOException;

}
