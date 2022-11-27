package feed;

public interface CreateFeedOutputBoundary {

    void successView(CreateFeedResponseModel model);

    void failView(String errDesc);
}
