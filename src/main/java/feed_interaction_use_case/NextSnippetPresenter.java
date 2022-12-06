package feed_interaction_use_case;

import DetailedFeedView.DetailedFeedViewModel;
import codesnippet.CodeSnippetRepoGateway;
import codesnippet.CodeSnippetRequestModel;
import feed.FeedDSRepository;
import feed.FeedGatewayResponseModel;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class NextSnippetPresenter implements NextSnippetOutputBoundary{

    final FeedDSRepository repository;
    final CodeSnippetRepoGateway codeSnippetRepoGateway;
    private DetailedFeedViewModel viewModel;

    public NextSnippetPresenter(FeedDSRepository repository, CodeSnippetRepoGateway codeSnippetRepoGateway, DetailedFeedViewModel viewModel) {
        this.repository = repository;
        this.codeSnippetRepoGateway = codeSnippetRepoGateway;
        this.viewModel = viewModel;
    }

    /**
     * This method finds the list of locations of the code snippets in the feed. Then it makes a call to the view model
     * passing in the list of code snippet locations, and the index of the current code snippet. The view model will
     * use this information to determine which code snippet needs to be displayed in the view, and it updates the view.
     * @param responseModel contains the id of the feed which we want to update.
     */
    @Override
    public void showNextSnippet(NextSnippetResponseModel responseModel) {
        FeedGatewayResponseModel feed = repository.load(responseModel.getFeedId());
        int current = feed.getCurr();
        List<String> SnippetIDs = feed.getSnippetIDs();
        List<String> SnippetLocations = new ArrayList<>();
        for(String s: SnippetIDs){
            CodeSnippetRequestModel codeSnippetRequestModel = codeSnippetRepoGateway.retrieve(parseInt(s));
            String location = codeSnippetRequestModel.getFileUrl();
            SnippetLocations.add(location);
        }
        // we need to add 1 because the variable curr starts from -1
        viewModel.nextSnippet(SnippetLocations, current+1);
    }

    /**
     * This method triggers a call to the reportFail method in the ViewModel to display and error in the screen.
     * @param message the error message to be displayed in the View.
     */
    @Override
     public void prepareFailView(String message) {
        viewModel.reportFail(message);
    }
}
