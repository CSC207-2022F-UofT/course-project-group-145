package feed_interaction_use_case;

import entities.FeedFactory;
import feed.FeedDSRepository;
import feed.FeedGatewayResponseModel;

import java.io.IOException;

public class NextSnippetUseCase implements NextSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final FeedFactory feedFactory;
    final NextSnippetOutputBoundary outputBoundary;

    public NextSnippetUseCase(FeedDSRepository feedDSRepository, FeedFactory feedFactory,
                              NextSnippetPresenter outputBoundary) {
        this.feedDSRepository = feedDSRepository;
        this.feedFactory = feedFactory;
        this.outputBoundary = outputBoundary;
    }

    /**
     * This method advances the feed represented by nextSnippetRequestModel to the next current snippet in the feed.
     * It retrieves the feed from the Repository and edits it to update the variable that determines the current
     * snippet in the feed. Then it calls the output boundary so that the effect will be shown in the UI.
     * If there is no next current snippet, the UI will display a message that says so.
     * @param nextSnippetRequestModel the request model created in the controller with the id of the feed.
     * @throws IOException this exception is thrown in case the feed id does not exist
     */
    @Override

    public void next(NextSnippetRequestModel nextSnippetRequestModel) throws IOException {
        FeedGatewayResponseModel feed = feedDSRepository.load(nextSnippetRequestModel.getFeedId());

        if(feed.getCurr() < (feed.getSnippetIDs().size()-1)) {
            int curr = feed.getCurr();
            String nextSnippetId = feed.getSnippetIDs().get(curr + 1);
            NextSnippetResponseModel responseModel = new NextSnippetResponseModel(nextSnippetId);
            feedDSRepository.advanceFeed(nextSnippetRequestModel.getFeedId());
            outputBoundary.showNextSnippet(responseModel);
        } else {
            outputBoundary.prepareFailView("You have scrolled through all code snippets in the feed.");
        }
    }
}
