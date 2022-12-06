package use_cases.feed_interaction_use_case;

public interface CurrentSnippetOutputBoundary {
    public void getSnippet(CurrentSnippetResponseModel responseModel);
    public void prepareFailView(String error);
}
