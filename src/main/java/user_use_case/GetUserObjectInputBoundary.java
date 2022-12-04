package user_use_case;

import user.UserRepoRequestModel;
import user.UserRequestModel;

import java.io.IOException;
import java.util.List;

public interface GetUserObjectInputBoundary {

    UserRepoRequestModel getUserObject(int userId) throws IOException;
}
