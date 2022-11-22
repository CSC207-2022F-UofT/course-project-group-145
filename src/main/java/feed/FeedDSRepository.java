package feed;


import java.io.IOException;

public interface FeedDSRepository {
    void save(FeedGatewayRequestModel request) throws IOException;

    FeedGatewayResponseModel load(String id);
}
