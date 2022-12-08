package use_cases.feed_interaction_use_case;

import controller_presenter_gateway.feed_controller_presenter_gateway.FeedDSRepository;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedGatewayResponseModel;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.NextSnippetOutputBoundary;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.NextSnippetResponseModel;

import java.io.IOException;

/**
 * Use case for user to advance onto next snippet in a feed
 */
public class NextSnippetUseCase implements NextSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final NextSnippetOutputBoundary outputBoundary;

    /**
     * Creates a new NextSnippetUseCase
     * @param feedDSRepository repository for feeds
     * @param outputBoundary presenter that implements NextSnippetOutputBoundary
     */
    public NextSnippetUseCase(FeedDSRepository feedDSRepository, NextSnippetOutputBoundary outputBoundary) {
        this.feedDSRepository = feedDSRepository;
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

        if((feed.getCurr()+1) < (feed.getSnippetIDs().size()-1)) {
            NextSnippetResponseModel responseModel = new NextSnippetResponseModel(nextSnippetRequestModel.getFeedId());
            feedDSRepository.advanceFeed(nextSnippetRequestModel.getFeedId());
            outputBoundary.showNextSnippet(responseModel);
        } else {
            outputBoundary.prepareFailView("You have scrolled through all code snippets in the feed!");
        }
    }
}
