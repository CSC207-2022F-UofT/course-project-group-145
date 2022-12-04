package feed;

import java.util.ArrayList;
import java.util.List;

public class CreateFeedPresenter implements CreateFeedOutputBoundary{

    private FeedViewModel model;
    private FeedDSRepository feedRepo;
    //private UserRepoGateway userRepo
    //TODO: User repo reference

    public CreateFeedPresenter(FeedViewModel model, FeedDSRepository feedRepo){
        this.model = model;
        this.feedRepo = feedRepo;


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
        //UserRepoRequestModel model = userRepo.
        List<Integer> listIDs = new ArrayList<>(); //TODO: Change to list as needed

    }

    @Override
    public void failView(String errDesc) {
        model.reportFailure(errDesc);
    }
}
