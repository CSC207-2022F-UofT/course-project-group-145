package feed;

import feed_use_case.CreateFeedUseCaseInputBoundary;

import java.util.List;

public class CreateFeedRequestModel {
    private int id;
    private List<String> tags;

    public CreateFeedRequestModel(int id, List<String> tags){
        this.id = id;
        this.tags = tags;
    }

}
