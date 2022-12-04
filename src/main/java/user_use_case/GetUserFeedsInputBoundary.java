package user_use_case;

import user.UserRequestModel;

import java.io.IOException;
import java.util.List;

public interface GetUserFeedsInputBoundary {

    List<Integer> getFeed(int userId) throws IOException;
}
