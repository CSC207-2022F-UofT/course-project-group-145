package feed;

import UI.ViewInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI that shows the user a list of feeds, as well as providing the user an option to view each feed in detail,
 * or generate a new feed.
 * Implements ActionListener for user inputs
 * Implements ViewInterface, which is a custom interface to mimic the deprecated Observer interface.
 */
public class FeedView extends JFrame implements ActionListener, ViewInterface {
    private FeedControllerInputBoundary controller;

    public FeedView(FeedControllerInputBoundary controller){
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Called whenever FeedViewModel is updated
     **/
    @Override
    public void update() {

    }

    @Override
    public void reportFail(String failMsg) {

    }
}
