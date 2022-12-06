package controller_presenter_gateway.feed_controller_presenter_gateway;

public interface CreateFeedOutputBoundary {
    void successView(CreateFeedResponseModel model);

    void failView(String errDesc);

}
