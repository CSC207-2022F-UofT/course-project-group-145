package feed_interaction_use_case;

import DetailedFeedView.DetailedFeedViewModel;
import codesnippet.CodeSnippetRepoGateway;
import codesnippet.CodeSnippetRequestModel;
import codesnippet.CodeSnippetResponseModel;
import feed.FeedDSRepository;
import feed.FeedGatewayResponseModel;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CurrentSnippetPresenter implements CurrentSnippetOutputBoundary{
    final FeedDSRepository repository;
    final CodeSnippetRepoGateway codeSnippetGateway;
    final DetailedFeedViewModel viewModel;

    public CurrentSnippetPresenter(FeedDSRepository feedGateway, CodeSnippetRepoGateway codeSnippetGateway, DetailedFeedViewModel viewModel) {
        this.repository = feedGateway;
        this.codeSnippetGateway = codeSnippetGateway;
        this.viewModel = viewModel;
    }

    /**
     * This method triggers a call to the nextSnippet method in the ViewModel passing in a list of the locations of
     * the code snippets, and the index of the code snippet that needs to be displayed in the View. The ViewModel will
     * then update the View.
     * @param responseModel contains the id of the feed for which we wish to display the current snippet.
     */
    @Override
    public void getSnippet(CurrentSnippetResponseModel responseModel) {
        FeedGatewayResponseModel feed = repository.load(responseModel.getFeedId());
        int current = feed.getCurr();
        List<String> SnippetIDs = feed.getSnippetIDs();
        List<String> SnippetLocations = new ArrayList<>();
        for(String s: SnippetIDs){
            CodeSnippetResponseModel codeSnippetRequestModel = codeSnippetGateway.retrieve(parseInt(s));
            String location = codeSnippetRequestModel.getFileUrl();
            SnippetLocations.add(location);
        }
        // we need to add 1 because the variable curr starts from -1.
        viewModel.nextSnippet(SnippetLocations, current+1);
    }

    /**
     * This method triggers a call to the perpareFailView method in the ViewModel to display an error message in the
     * screen.
     * @param error the error message to be displayed in the View.
     */
    @Override
    public void prepareFailView(String error) {
        viewModel.reportFail(error);
    }

}
