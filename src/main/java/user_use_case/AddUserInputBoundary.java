package user_use_case;

import user.UserRepoRequestModel;
import user.UserRequestModel;

import java.io.IOException;

public interface AddUserInputBoundary {

    void save(UserRequestModel requestModel) throws IOException;
}
