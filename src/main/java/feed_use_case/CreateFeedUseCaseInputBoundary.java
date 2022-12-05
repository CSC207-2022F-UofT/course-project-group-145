package feed_use_case;

import java.util.List;

public interface CreateFeedUseCaseInputBoundary {

    void createFeed(int userID, List<String> tags, int size);
    void createFeed(int userID, List<String> tags);
}
