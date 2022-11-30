package user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class UserRepository implements UserRepoGateway {

    private final File JSONFile;

    private String filePath;

    private Map<Integer, UserRepoRequestModel> users = new HashMap<>();

    private int numUsers;

    public UserRepository(String filePath) throws IOException {
        this.filePath = filePath;
        JSONFile = new File(filePath);
        this.numUsers = 0;
        if (JSONFile.length() > 0) {
            FileReader reader = new FileReader(JSONFile);
            Gson gson = new GsonBuilder().create();
            users = gson.fromJson(reader, new TypeToken<HashMap<Integer, UserRepoRequestModel>>() {}.getType());
            reader.close();
            this.numUsers = users.size();
        }
    }

    @Override
    public int getNumUsers(){
        return numUsers;
    }



    /**
     * Saves the user being created to the JSON

     */


    @Override
    public void save(UserRepoRequestModel requestModel) throws IOException {
        users.put(requestModel.getUserId(), requestModel);
        this.numUsers = this.numUsers + 1;
        saveJSON();
    }

    @Override
    public void delete(int userId) throws IOException {
        UserRepoRequestModel user = users.remove(userId);
        users.put(userId, user);
        saveJSON();
    }
    @Override
    public void addChatId(int userId, int chatId) throws IOException{
        UserRepoRequestModel user = users.remove(userId);
        Map<Integer, Integer> chatIds = user.getListOfChatIds();
        chatIds.put(chatId, userId);
        user.setListOfChatIds(chatIds);
        users.put(chatId, user);
        saveJSON();
    }

    @Override
    public void addFeedId(int userId, int feedId) throws IOException{
        UserRepoRequestModel user = users.remove(userId);
        List<Integer> feedIds = user.getListOfFeedIds();
        feedIds.add(feedId);
        user.setListOfFeedIds(feedIds);
        users.put(feedId, user);
        saveJSON();
    }

    private void saveJSON() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().create();
        gson.toJson(users, writer);
        writer.close();
    }
}