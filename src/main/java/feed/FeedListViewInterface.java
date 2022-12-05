package feed;

import java.util.List;

public interface FeedListViewInterface {

    void showError(String errDesc);

    void showFeedList(List<List<String>> tags);
}
