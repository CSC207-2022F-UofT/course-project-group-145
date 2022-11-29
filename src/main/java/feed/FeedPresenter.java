package feed;

public class FeedPresenter implements CreateFeedOutputBoundary{

    private FeedViewModel feedViewModel;

    @Override
    public void successView() {


    }

    @Override
    public void failView(String errDesc) {
        feedViewModel.reportFailure(errDesc);
    }
}
