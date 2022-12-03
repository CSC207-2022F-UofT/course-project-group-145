package DetailedFeedView;

import UI.ViewInterface;

import java.util.List;

public class DetailedFeedViewModel {
    private ViewInterface listener;

    private String snippetLocation;

    public DetailedFeedViewModel(ViewInterface listener){
        this.listener = listener;
    }

    public void nextSnippet(List<String> snippetLocations, int toDisplay){
        snippetLocation = snippetLocations.get(toDisplay);
        update();
    }

    private void update(){
        listener.update();
    }

    public void reportFail(String error){
        listener.reportFail(error);
    }
}