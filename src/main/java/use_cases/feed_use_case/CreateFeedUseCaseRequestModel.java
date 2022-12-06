package use_cases.feed_use_case;

import java.util.List;

public class CreateFeedUseCaseRequestModel {

    private int userID;
    private List<String> tags;
    private int size;

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
