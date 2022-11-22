package feed_interaction_use_case;

public interface NextSnippetOutputBoundary {
    NextSnippetResponseModel showNextSnippet(NextSnippetResponseModel responseModel);
    NextSnippetResponseModel prepareFailView(String message);
}
