package controller_presenter_gateway.feed_interaction_controller_presenter_gateway;

public interface NextSnippetOutputBoundary {
    void showNextSnippet(NextSnippetResponseModel responseModel);
    void prepareFailView(String message);
}
