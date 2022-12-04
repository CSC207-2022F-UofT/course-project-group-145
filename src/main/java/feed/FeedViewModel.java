package feed;

import ui.ViewInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * FeedViewModel contains all the information necessary for constructing a view for the user.
 * It is observed by implementations of ViewInterface (custom class used because Observer is deprecated)
 * ViewInterface listeners can be added via the addListener method
 * @author PotatoRations (Aerin)
 */
public class FeedViewModel {

    private List<ViewInterface> listeners;

    //Feeds organised by their id and tags, maybe will implement a creation date system
    private Map<Integer, List<String>> feeds;

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
        feeds.put(id, tags);
        update();
    }

    /**
     * changes feeds to the new incoming lists
     * @param feeds map that maps a feed ID to a list of its tags as strings
     */
    public void updateFeedList(Map<Integer, List<String>> feeds){
        this.feeds = feeds;
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
}
