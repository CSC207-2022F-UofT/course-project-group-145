package entities;

import java.util.List;
import java.util.Map;

public class User {

    private static int numUsers = 0;

    private int userId;

    private String username;

    private String password;

    private String email;

    private Map<Integer, Integer> mapOfChatToOtherUser;

    private List<Integer> listOfFeedIds;

    private boolean isDeleted;

    User(String username, String password, String email, Map<Integer, Integer> chats, List<Integer> feeds){
        this.username = username;
        this.password = password;
        this.email = email;
        this.mapOfChatToOtherUser = chats;
        this.listOfFeedIds = feeds;
        this.isDeleted = false;
        this.userId = numUsers;
        numUsers = numUsers + 1;
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
        this.mapOfChatToOtherUser = mapOfChatToOtherUser;
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

    public static void setNumUsers(int numUsers) {
        User.numUsers = numUsers;
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