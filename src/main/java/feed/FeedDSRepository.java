package feed;


import java.io.IOException;

public interface FeedDSRepository {
    void save(FeedGatewayRequestModel request) throws IOException;

    FeedGatewayResponseModel load(String id);

    void advanceFeed(String id) throws IOException;

    void match(String id) throws IOException;

}
