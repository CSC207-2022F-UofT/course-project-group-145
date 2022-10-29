package entities;

import java.util.List;

class User {
    private static int numUsers = 0;

    private int userId;

    private String username;

    private String password;

    private String email;

    private List<Integer> listOfChatIds;

    private List<Integer> listOfFeedIds;

    User(String username, String password, String email, List<Integer> chats, List<Integer> feeds){
        this.username = username;
        this.password = password;
        this.email = email;
        this.listOfChatIds = chats;
        this.listOfFeedIds = feeds;
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

    public List<Integer> getListOfChatIds() {
        return listOfChatIds;
    }

    public void setListOfChatIds(List<Integer> listOfChatIds) {
        this.listOfChatIds = listOfChatIds;
    }

    public List<Integer> getListOfFeedIds() {
        return listOfFeedIds;
    }

    public void setListOfFeedIds(List<Integer> listOfFeedIds) {
        this.listOfFeedIds = listOfFeedIds;
    }

    public void deleteChat(int chatId) {

    }

    public void addChat(int chatId){

    }


}