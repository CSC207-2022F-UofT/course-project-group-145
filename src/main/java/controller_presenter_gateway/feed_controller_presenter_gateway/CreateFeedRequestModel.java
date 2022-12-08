package controller_presenter_gateway.feed_controller_presenter_gateway;

import java.util.List;

/**
 * Request model used to call Create feed use case
 */
public class CreateFeedRequestModel {
    private int id;
    private List<String> tags;

    /**
     * Creates a new CreateFeedRequestModel
     * @param id id of user
     * @param tags List of tags to search for
     */
    public CreateFeedRequestModel(int id, List<String> tags){
        this.id = id;
        this.tags = tags;
    }

}
