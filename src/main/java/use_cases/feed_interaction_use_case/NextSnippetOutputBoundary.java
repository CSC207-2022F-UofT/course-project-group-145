package use_cases.feed_interaction_use_case;

public interface NextSnippetOutputBoundary {
    void showNextSnippet(NextSnippetResponseModel responseModel);
    void prepareFailView(String message);
}
