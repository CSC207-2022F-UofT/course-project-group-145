package ui;

import java.util.ArrayList;
import java.util.List;

/**
 * FeedViewModel contains all the information necessary for constructing a view for the user.
 * It is observed by implementations of ViewInterface (custom class used because Observer is deprecated)
 * ViewInterface listeners can be added via the addListener method
 * @author PotatoRations (Aerin)
 */
public class FeedViewModel {

    private List<ViewInterface> listeners;

    //Feeds organised by their id and tags, maybe will implement a creation date system
    private List<Integer> idList;
    private List<List<String>> tagList;
    /**
     * Creates a new FeedViewModel
     * FeedViewModel contains all the information necessary for constructing a view for the user.
     * It is observed by implementations of ViewInterface (custom class used because Observer is deprecated)
     * ViewInterface listeners can be added via the addListener method
     */
    public FeedViewModel(){
        this.listeners = new ArrayList<>();
    }
    /**
     * Creates a new FeedViewModel
     * FeedViewModel contains all the information necessary for constructing a view for the user.
     * It is observed by implementations of ViewInterface (custom class used because Observer is deprecated)
     * ViewInterface listeners can be added via the addListener method
     * @param listeners a list of objects that implement ViewInterface that will replace the current list of listeners
     */
    public FeedViewModel(List<ViewInterface> listeners){
        this.listeners = listeners;
    }

    /**
     * Adds a feed to the list of feeds in the viewModel, then updates the view
     * @param id id of the feed in the feed repository
     * @param tags the tags of the feed
     */
    public void addFeed(int id, List<String> tags){
        this.idList.add(id);
        this.tagList.add(tags);
        update();
    }

    /**
     * changes feeds to the new incoming lists
     * @param idList List of the feedIDs of the feeds
     * @param tagsList List of tags of each of the feeds
     *                 Lists are parallel
     */
    public void updateFeedMap(List<Integer> idList, List<List<String>> tagsList) {
        this.idList = idList;
        this.tagList = tagsList;
        update();
    }

    private void update(){
        for (ViewInterface listener: listeners){
            listener.update();
        }
    }

    public void reportFailure(String errMsg){
        for (ViewInterface listener: listeners){
            listener.reportFail(errMsg);
        }
    }

    /**
     * Adds a new ViewInterface listener to this viewmodel, this class will update the listener when it has been changed
     * @param listener listener implementing ViewInterface to be added
     */
    public void addListener(ViewInterface listener){
        this.listeners.add(listener);
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public List<List<String>> getTagList() {
        return tagList;
    }
}
