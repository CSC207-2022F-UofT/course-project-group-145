package ui;

import java.util.List;

/**
 * View model containing all the information needed to construct a UI for viewing feeds in detail
 */
public class DetailedFeedViewModel {
    private ViewInterface listener;

    private String snippetLocation;
    private int userID;

    private int feedId;

    /**
     * Creates a new DetailedFeedViewModel, and adds a view to for this view model to update as a listener
     * @param listener
     */
    public DetailedFeedViewModel(ViewInterface listener){
        this.listener = listener;
    }

    /**
     * Creates a new DetailedFeedViewModel without adding a listener to it
     */
    public DetailedFeedViewModel(){

    }

    /**
     * adds a view to for this view model to update as a listener
     * @param listener view to add as listener
     */
    public void addListener(ViewInterface listener){
        this.listener=listener;
    }

    /**
     * moves to the next snippet and updates the view
     * @param snippetLocations
     * @param toDisplay
     */
    public void nextSnippet(List<String> snippetLocations, int toDisplay){
        snippetLocation = snippetLocations.get(toDisplay);
        update();
    }

    private void update(){
        listener.update();
    }

    /**
     * Tells the view to report a failure with the given message
     * @param error error message to show to user
     */
    public void reportFail(String error){
        listener.reportFail(error);
    }

    public String getSnippetLocation() {
        return snippetLocation;
    }

    public int getFeedId(){
        return feedId;
    }
    public void setFeedId(int id){
        this.feedId = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
