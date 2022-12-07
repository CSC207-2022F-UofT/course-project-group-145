package use_cases.feed_interaction_use_case;

import controller_presenter_gateway.feed_controller_presenter_gateway.FeedDSRepository;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedGatewayResponseModel;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.CurrentSnippetOutputBoundary;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.CurrentSnippetResponseModel;

import java.io.IOException;

public class CurrentSnippetUseCase implements CurrentSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final CurrentSnippetOutputBoundary outputBoundary;

    public CurrentSnippetUseCase(FeedDSRepository feedDSRepository, CurrentSnippetOutputBoundary outputBoundary) {
        this.feedDSRepository = feedDSRepository;
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
        if (responseModel.getCurr() < (responseModel.getSnippetIDs().size()-1)) {
            CurrentSnippetResponseModel currentSnippetResponseModel = new CurrentSnippetResponseModel(requestModel.getFeedId());
            outputBoundary.getSnippet(currentSnippetResponseModel);
        } else {
            outputBoundary.prepareFailView("This feed is empty");
        }
    }
}
