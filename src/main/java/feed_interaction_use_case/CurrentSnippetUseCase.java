package feed_interaction_use_case;

import entities.FeedFactory;
import feed.FeedDSRepository;
import feed.FeedGatewayResponseModel;

import java.io.IOException;

public class CurrentSnippetUseCase implements CurrentSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final FeedFactory feedFactory;
    final CurrentSnippetOutputBoundary outputBoundary;

    public CurrentSnippetUseCase(FeedDSRepository feedDSRepository, FeedFactory feedFactory, CurrentSnippetOutputBoundary outputBoundary) {
        this.feedDSRepository = feedDSRepository;
        this.feedFactory = feedFactory;
        this.outputBoundary = outputBoundary;
    }

    /**
     * This method returns the current code snippet in the feed represented by this request model. To find the
     * current snippet, I first retrieve the feed by id from the repository, and then I obtain the id of the
     * current snippet. Then I make a call to the presenter so that the UI displays the Code Snippet with that id.
     * @param requestModel the request model that gets created in the controller containing all information about
     *                     the feed that we need to know.
     * @throws IOException this is thrown in case there does not exist a feed with such id.
     */
    @Override
    public void current(CurrentSnippetRequestModel requestModel) throws IOException {
        FeedGatewayResponseModel responseModel = feedDSRepository.load(requestModel.getFeedId());
        String snippetId = responseModel.getSnippetIDs().get(responseModel.getCurr());
        CurrentSnippetResponseModel currentSnippetResponseModel = new CurrentSnippetResponseModel(snippetId);
        outputBoundary.getSnippet(currentSnippetResponseModel);
    }
}
