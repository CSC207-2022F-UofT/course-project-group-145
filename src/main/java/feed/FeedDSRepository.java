package feed;


import java.io.IOException;

public interface FeedDSRepository {
    int numFeeds();
    void save(FeedGatewayRequestModel request) throws IOException;

    FeedGatewayResponseModel load(String id);
}
