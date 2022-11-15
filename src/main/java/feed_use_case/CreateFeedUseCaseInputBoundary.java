package feed_use_case;

import java.util.List;

public interface CreateFeedUseCaseInputBoundary {

    void createFeed(List<String> tags);
}
