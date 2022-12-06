package controller_presenter_gateway.feed_controller_presenter_gateway;

import java.util.List;

public class CreateFeedRequestModel {
    private int id;
    private List<String> tags;

    public CreateFeedRequestModel(int id, List<String> tags){
        this.id = id;
        this.tags = tags;
    }

}
