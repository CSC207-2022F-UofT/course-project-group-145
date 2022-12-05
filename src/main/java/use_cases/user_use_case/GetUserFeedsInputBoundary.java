package use_cases.user_use_case;

import java.io.IOException;
import java.util.List;

public interface GetUserFeedsInputBoundary {

    List<Integer> getFeed(int userId) throws IOException;
}
