package feed_interaction_use_case;

import DetailedFeedView.DetailedFeedViewModel;
import codesnippet.CodeSnippetRepoGateway;
import codesnippet.CodeSnippetRequestModel;
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

    @Override
    public void getSnippet(CurrentSnippetResponseModel responseModel) {
        FeedGatewayResponseModel feed = repository.load(responseModel.getFeedId());
        int current = feed.getCurr();
        List<String> SnippetIDs = feed.getSnippetIDs();
        List<String> SnippetLocations = new ArrayList<>();
        for(String s: SnippetIDs){
            CodeSnippetRequestModel codeSnippetRequestModel = codeSnippetGateway.retrieve(parseInt(s));
            String location = codeSnippetRequestModel.getFileUrl();
            SnippetLocations.add(location);
        }
        viewModel.nextSnippet(SnippetLocations, current);
    }

    @Override
    public void prepareFailView(String error) {
        viewModel.reportFail(error);
    }

}
