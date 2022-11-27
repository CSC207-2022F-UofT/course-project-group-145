package feed;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.security.PrivateKey;
import java.util.List;
import java.util.Observable;

public class FeedViewModel {

    private List<PropertyChangeListener> Listeners;
    //Feeds organised by their tags, maybe will implement a creation date system
    private List<List<String>> feeds;

    public FeedViewModel(){

    }

    public

    private void notify(){
        for (PropertyChangeListener listener: Listeners){
            listener.propertyChange(new PropertyChangeEvent());
        }
    }
}
