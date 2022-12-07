package controller_presenter_gateway.feed_controller_presenter_gateway;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedRepository implements FeedDSRepository{
    private final String filePath;
    private int numFeeds;

    private Map<String, FeedGatewayRequestModel> feeds = new HashMap<>();

    public FeedRepository(String filePath) throws IOException {
        this.filePath = filePath;
        File JSONFile = new File(filePath);
        this.numFeeds = 0;
        if(JSONFile.length() > 0){
            FileReader reader = new FileReader(JSONFile);
            Gson gson = new GsonBuilder().create();
            feeds = gson.fromJson(reader, new TypeToken<HashMap<String, FeedGatewayRequestModel>>() {}.getType());
            reader.close();
            this.numFeeds = feeds.size();
        }
    }

    /**
     * Saves the feed represented by the request model to the json file.
     * @param requestModel represents a new feed that we want to save to the json file.
     * @throws IOException
     */
    @Override
    public void save(FeedGatewayRequestModel requestModel) throws IOException {
        if(feeds.containsKey(requestModel.getFeedId())){
            feeds.remove(requestModel.getFeedId());
            feeds.put(requestModel.getFeedId(), requestModel);
            return;
        }
        feeds.put(requestModel.getFeedId(), requestModel);
        numFeeds += 1;
        saveJSON();
    }

    /**
     * Finds the feed with id FeedID and returns all its information in the form of a FeedGatewayResponseModel.
     * @param FeedId id of the feed that we wish to retrieve.
     * @return a FeedGatewayResponseModel that contains all the information about the feed.
     */
    @Override
    public FeedGatewayResponseModel load(String FeedId) {
        if(feeds.containsKey(FeedId)){
            FeedGatewayRequestModel requestModel = feeds.get(FeedId);
            FeedGatewayResponseModel responseModel = new FeedGatewayResponseModel(
                    requestModel.getSnippetIDs(), requestModel.getMatchedIDs(),
                    requestModel.getTags(), requestModel.getCurr(), requestModel.getUserId());
            return responseModel;
        } else {
            return null;
        }
    }

    /**
     * Increments the variable curr by 1. This variable determines which snippet from the list the feed is at.
     * @param FeedId id of the feed that we wish to advance.
     * @throws IOException
     */
    @Override
    public void advanceFeed(String FeedId) throws IOException {
        if(feeds.containsKey(FeedId)){
            FeedGatewayRequestModel requestModel = feeds.get(FeedId);
            int current = requestModel.getCurr();
            requestModel.setCurr(current+1);
            saveJSON();
        }
    }

    /**
     * Adds the snippet id of the current snippet to the list of matched snippet ids. It also advances the feed to
     * the next code snippet.
     * @param FeedId id of the feed for which we wish to create the match.
     * @throws IOException
     */
    @Override
    public void match(String FeedId) throws IOException {
        if(feeds.containsKey(FeedId)){
            FeedGatewayRequestModel requestModel = feeds.get(FeedId);
            String snippetId = requestModel.getSnippetIDs().get(requestModel.getCurr());
            List<String> newMatched = new ArrayList<>(requestModel.getMatchedIDs());
            newMatched.add(snippetId);
            requestModel.setMatchedIDs(newMatched);
            requestModel.setCurr(requestModel.getCurr()+1);
            saveJSON();
        }
    }

    @Override
    public int numFeeds() {
        return feeds.size();
    }

    private void saveJSON() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().create();
        gson.toJson(feeds, writer);
        writer.close();
    }

}
