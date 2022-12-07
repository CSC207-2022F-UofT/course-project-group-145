package controller_presenter_gateway.feed_interaction_controller_presenter_gateway;

public interface CurrentSnippetOutputBoundary {
    public void getSnippet(CurrentSnippetResponseModel responseModel);
    public void prepareFailView(String error);
}
