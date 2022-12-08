package controller_presenter_gateway.user_controller_presenter_gateway;

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

/**
 * Repository for storing user data as a JSON and in memory
 */
public class UserRepository implements UserRepoGateway {

    private final File JSONFile;

    private String filePath;

    private Map<Integer, UserRepoRequestModel> users = new HashMap<>();

    private int numUsers;

    /**
     * Creates and initialises a new UserRepository
     * Loads data from file into memory if it exists
     * @param filePath path to persistent JSON file
     * @throws IOException
     */
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

    @Override
    public Map<Integer, UserRepoRequestModel> getAllUsers() {return this.users;}


    /**
     * Saves user to repository, and saves it to JSON
     * @param requestModel request model containing all relevant user data
     * @throws IOException
     */
    @Override
    public void save(UserRepoRequestModel requestModel) throws IOException {
        users.put(requestModel.getUserId(), requestModel);
        this.numUsers = this.numUsers + 1;
        saveJSON();
    }

    /**
     * Deletes a user from the repository
     * Soft delete - adds a deleted flag to the user entry in repo
     * @param userId id of user to delete
     * @throws IOException
     */
    @Override
    public void delete(int userId) throws IOException {
        UserRepoRequestModel user = users.remove(userId);
        user.setDeleted(true);
        users.put(userId, user);
        saveJSON();
    }

    /**
     * Adds a chat to a user and saves the updated data
     * @param userId ID of user
     * @param chatId ID of chat to add to user
     * @throws IOException
     */
    @Override
    public void addChatId(int userId, int chatId) throws IOException{
        UserRepoRequestModel user = users.remove(userId);
        Map<Integer, Integer> chatIds = user.getListOfChatIds();
        chatIds.put(chatId, userId);
        user.setListOfChatIds(chatIds);
        users.put(userId, user);
        saveJSON();
    }

    /**
     * Adds a feed to the user and saves the updated data
     * @param userId id of user
     * @param feedId id of feed to add to user
     * @throws IOException
     */
    @Override
    public void addFeedId(int userId, int feedId) throws IOException{
        UserRepoRequestModel user = users.remove(userId);
        List<Integer> feedIds = user.getListOfFeedIds();
        feedIds.add(feedId);
        user.setListOfFeedIds(feedIds);
        users.put(userId, user);
        saveJSON();
    }

    /**
     * Get the id of all feeds of a user
     * @param userId id of user to get feeds from
     * @return a list containing the ID of feeds belonging to the user
     * @throws IOException
     */
    @Override
    public List<Integer> getFeeds(int userId) throws IOException{
        UserRepoRequestModel user = users.remove(userId);
        List<Integer> feedIds = user.getListOfFeedIds();
        users.put(userId, user);
        saveJSON();
        return feedIds;
    }

    /**
     * Returns a UserRepoRequestModel containing all saved information about the user
     * @param userId id of user to retrieve info about
     * @return UserRepoRequestModel containing all saved information about the user
     * @throws IOException
     */
    @Override
    public UserRepoRequestModel getUser(int userId) throws IOException{
        UserRepoRequestModel user = users.remove(userId);
        users.put(userId, user);
        saveJSON();
        return user;
    }

    private void saveJSON() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().create();
        gson.toJson(users, writer);
        writer.close();
    }
}