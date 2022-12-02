package feed;

public class FeedPresenter implements CreateFeedOutputBoundary{

    private FeedViewModel feedViewModel;
    private FeedDSRepository repo;
    //TODO: User repo reference

    /**
     * successView called by CreateFeedUseCase to signify that use case was successful.
     * In this case, a new feed was created, and that the feedViewModel should be updated with a new list of feeds
     */
    @Override
    public void successView() {


    }

    @Override
    public void failView(String errDesc) {
        feedViewModel.reportFailure(errDesc);
    }
}
