package feed_interaction_use_case;

public class NextSnippetPresenter implements NextSnippetOutputBoundary{

    @Override
    public NextSnippetResponseModel showNextSnippet(NextSnippetResponseModel responseModel) {
        // go into the code snippet repo and find the code snippet
        return null;
    }

    @Override
    public NextSnippetResponseModel prepareFailView(String message) {
        return null;
    }
}
