package use_cases.feed_use_case;

import java.util.List;

/**
 * Request model used to call Create feed use case
 */
public class CreateFeedUseCaseRequestModel {

    private int userID;
    private List<String> tags;
    private int size;

    /**
     * Creates a new CreateFeedRequestModel
     * @param userID id of user
     * @param tags List of tags to search for
     * @param size size of feed to generate
     */
    public CreateFeedUseCaseRequestModel(int userID, List<String> tags, int size){
        this.userID = userID;
        this.tags = tags;
        this.size = size;
    }

    public int getUserID() {
        return userID;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getSize() {
        return size;
    }
}
