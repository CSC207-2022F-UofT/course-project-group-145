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
 * Presenter that updates the view with the information on the current snippet in a feed
 */
public class CurrentSnippetPresenter implements CurrentSnippetOutputBoundary {
    final FeedDSRepository repository;
    final CodeSnippetRepoGateway codeSnippetGateway;
    final DetailedFeedViewModel viewModel;

    /**
     * Creates a new CurrentSnippetPresenter
     * @param feedGateway instance of feed repository
     * @param codeSnippetGateway  instance of code snippet repo
     * @param viewModel view model of view to update
     */
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
        viewModel.setFeedId(Integer.parseInt(responseModel.getFeedId()));
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
