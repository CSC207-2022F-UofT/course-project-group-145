package feed;


import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CreateFeedPresenter, this class updates the FeedViewModel with the results of CreateFeedUseCase
 */
public class CreateFeedPresenter implements CreateFeedOutputBoundary{

    private FeedViewModel viewModel;
    private FeedDSRepository feedRepo;
    private UserRepoGateway userRepo;

    /**
     * Constructor for creating a c
     * @param viewModel the FeedViewModel that this presenter will update
     * @param feedRepo the gateway to the feed repository
     * @param userRepo the gateway to the user repository
     */
    public CreateFeedPresenter(FeedViewModel viewModel, FeedDSRepository feedRepo, UserRepoGateway userRepo){
        this.viewModel = viewModel;
        this.feedRepo = feedRepo;
        this.userRepo = userRepo;
    }

    /**
     * successView called by CreateFeedUseCase to signify that use case was successful.
     * In this case, a new feed was created, and that the feedViewModel should be updated with a new list of feeds
     */
    @Override
    public void successView(CreateFeedResponseModel model) {
        updateView(model.getUserID());
    }

    private void updateView(int userID){
        //Get list of feed IDs from repo
        try {
            List<Integer> feedIDs = userRepo.getFeeds(userID);
            List<List<String>> tagsList = new ArrayList<>();
            for (int id : feedIDs){
                FeedGatewayResponseModel feedModel = feedRepo.load(String.valueOf(id));
                tagsList.add(feedModel.getTags());
            }
            viewModel.updateFeedMap(feedIDs, tagsList);
        }
        catch (IOException e){
            failView("Unable to load feeds, please refresh and try again");
        }
    }

    @Override
    public void failView(String errDesc) {
        viewModel.reportFailure(errDesc);
    }
}
