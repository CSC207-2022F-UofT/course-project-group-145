package use_cases.feed_use_case;

import controller_presenter_gateway.feed_controller_presenter_gateway.CreateFeedOutputBoundary;
import controller_presenter_gateway.feed_controller_presenter_gateway.CreateFeedResponseModel;

/**
 * Opens the feed list from home page
 */
public class OpenFeedListUseCase implements OpenFeedListInputBoundary{
    private CreateFeedOutputBoundary output;
    public OpenFeedListUseCase(CreateFeedOutputBoundary output){
        this.output = output;
    }
    @Override
    public void open(int userID) {
        output.successView(new CreateFeedResponseModel(userID));
    }
}
