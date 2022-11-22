package feed_interaction_use_case;

import entities.FeedFactory;
import feed.FeedDSRepository;

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

    @Override
    public void next(NextSnippetRequestModel nextSnippetRequestModel){
        // create a new FeedGatewayRequestModel with info from nextSnippetUseCaseRequestModel
        // save this new object into the repository
        // feedDSRepository.save()
        if(nextSnippetRequestModel.getCurr() < nextSnippetRequestModel.getSnippetIDs().size()-1) {
            int curr = nextSnippetRequestModel.getCurr();
            String nextSnippetId = nextSnippetRequestModel.getSnippetIDs().get(curr + 1);
            NextSnippetResponseModel responseModel = new NextSnippetResponseModel(nextSnippetId);
            outputBoundary.showNextSnippet(responseModel);
        } else {
            outputBoundary.prepareFailView("You have scrolled through all code snippets in the feed.");
        }
    }
}
