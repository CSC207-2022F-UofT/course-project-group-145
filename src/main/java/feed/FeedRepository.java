package feed;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.HashMap;
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
    @Override
    public void save(FeedGatewayRequestModel requestModel) throws IOException {
//        if(feeds.containsKey(requestModel.getId())){
//            feeds.remove(requestModel.getId());
//            feeds.put(requestModel.getId(), requestModel);
//            return;
//        }
//        feeds.put(requestModel.getId(), requestModel);
//        numFeeds += 1;
//        saveJSON();
    }

    @Override
    public FeedGatewayResponseModel load(String FeedId) {
        if(feeds.containsKey(FeedId)){
            FeedGatewayRequestModel requestModel = feeds.get(FeedId);
            FeedGatewayResponseModel responseModel = new FeedGatewayResponseModel(
                    requestModel.getSnippetIDs(), requestModel.getMatchedIDs(),
                    requestModel.getTags(), requestModel.getCurr());
            return responseModel;
        } else {
            return null;
        }
    }
    private void saveJSON() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().create();
        gson.toJson(feeds, writer);
        writer.close();
    }

}
