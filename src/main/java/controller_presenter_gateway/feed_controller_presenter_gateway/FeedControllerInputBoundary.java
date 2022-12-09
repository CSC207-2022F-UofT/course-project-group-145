package controller_presenter_gateway.feed_controller_presenter_gateway;

import java.io.IOException;

public interface FeedControllerInputBoundary {
    void createNewFeed(FeedControllerInputModel model);
    void goBack(int userID);
    void openDetail(int userID, int feedID) throws IOException;
}
