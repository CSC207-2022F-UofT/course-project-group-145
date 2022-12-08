package controller_presenter_gateway.user_controller_presenter_gateway;

import java.util.List;
import java.util.Map;

/**
 * Response model for add user use case to send relevant information to presenter to update view
 */
public class UserResponseModel {

    private static int numUsers = 0;

    private int userId;

    private String username;

    private String password;

    private String email;

    private Map<Integer, Integer> mapOfChatToOtherUser;

    private List<Integer> listOfFeedIds;

    private boolean isDeleted;

    /**
     * Creates a new UserResponseModel
     * @param userId id of user added
     * @param username username of user
     * @param password password of user
     * @param email email of user
     * @param mapOfChatToOtherUser map of chat ids to the id of other user in chat
     * @param listOfFeedIds  list of ids of feeds belonging to user
     * @param isDeleted flag representing if this user is deleted or not
     */
    public UserResponseModel(int userId, String username, String password, String email, Map<Integer, Integer> mapOfChatToOtherUser, List<Integer> listOfFeedIds, Boolean isDeleted) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mapOfChatToOtherUser = mapOfChatToOtherUser;
        this.listOfFeedIds = listOfFeedIds;
        this.isDeleted = isDeleted;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<Integer, Integer> getListOfChatIds() {
        return mapOfChatToOtherUser;
    }

    public void setListOfChatIds(Map<Integer, Integer> mapOfChatToOtherUser) {
        this.mapOfChatToOtherUser= mapOfChatToOtherUser;
    }

    public List<Integer> getListOfFeedIds() {
        return listOfFeedIds;
    }

    public void setListOfFeedIds(List<Integer> listOfFeedIds) {
        this.listOfFeedIds = listOfFeedIds;
    }

    public static int getNumUsers() {
        return numUsers;
    }

    public void deleteChat(int chatId) {

    }

    public void addChat(int chatId){

    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }


}
