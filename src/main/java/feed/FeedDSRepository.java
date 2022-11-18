package feed;


public interface FeedDSRepository {
    void save(FeedGatewayRequestModel request);

    FeedGatewayResponseModel load(String id);
}
