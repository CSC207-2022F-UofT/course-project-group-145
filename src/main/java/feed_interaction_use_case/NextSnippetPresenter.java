package feed_interaction_use_case;

import DetailedFeedView.DetailedFeedViewModel;
import feed.FeedDSRepository;
import feed.FeedGatewayResponseModel;

public class NextSnippetPresenter implements NextSnippetOutputBoundary{

    final FeedDSRepository repository;

    private DetailedFeedViewModel viewModel;

    public NextSnippetPresenter(FeedDSRepository repository, DetailedFeedViewModel viewModel) {
        this.repository = repository;
        this.viewModel = viewModel;
    }

    @Override
    public void showNextSnippet(NextSnippetResponseModel responseModel) {
        FeedGatewayResponseModel feed = repository.load(responseModel.getFeedId());
        // TODO: obtain code snippet locations and the index of the current code snippet
        // TODO: call the viewModel.showNextSnippet() passing in the parameters
    }

    @Override
     public void prepareFailView(String message) {
        viewModel.reportFail(message);
    }
}
