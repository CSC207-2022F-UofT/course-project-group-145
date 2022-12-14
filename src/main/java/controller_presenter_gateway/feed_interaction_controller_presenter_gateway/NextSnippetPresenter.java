package controller_presenter_gateway.feed_interaction_controller_presenter_gateway;

import ui.DetailedFeedViewModel;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRepoGateway;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedDSRepository;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedGatewayResponseModel;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * NextSnippetPresenter, which updates the detailed feed view model with data from the next feed use case
 */
public class NextSnippetPresenter implements NextSnippetOutputBoundary {

    final FeedDSRepository repository;
    final CodeSnippetRepoGateway codeSnippetRepoGateway;
    private DetailedFeedViewModel viewModel;

    /**
     * Creates a new NextSnippetPresenter, which updates the detailed feed view model
     * @param repository repository that stores feed data
     * @param codeSnippetRepoGateway repository that stores code snippet data
     * @param viewModel view model for detailed feed view
     */
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
            CodeSnippetResponseModel codeSnippetRequestModel = codeSnippetRepoGateway.retrieve(parseInt(s));
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
