package ui;

import controller_presenter_gateway.hompage_controller_presenter.HomePageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Java swing UI of the homepage presented to user after they log in
 */
public class HomePageView extends JPanel implements HomePageViewInterface, ActionListener {

    private int userId;

    private HomePageController controller;

    /**
     * Create the UI for the homepage, which simply contains some buttons
     *
     */
    public HomePageView(){
        JLabel title = new JLabel("Home");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton chatList = new JButton("Chat List");
        JButton logOut = new JButton("Log Out");
        JButton feedList = new JButton("Feed List");

        JPanel chatListButton = new JPanel();
        chatListButton.add(chatList);
        JPanel logOutButton = new JPanel();
        logOutButton.add(logOut);
        JPanel feedListButton = new JPanel();
        feedListButton.add(feedList);

        chatList.addActionListener(this);
        chatList.setActionCommand("List");
        logOut.addActionListener(this);
        logOut.setActionCommand("Log Out");
        feedList.addActionListener(this);
        feedList.setActionCommand("FeedList");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(chatListButton);
        this.add(feedListButton);
        this.add(logOutButton);


    }

    /**
     * Deal with the button clicks
     *
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getActionCommand().equals("List")) {
            try {
                this.controller.openList(this.userId);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.setVisible(false);
        }
        else if (evt.getActionCommand().equals("Log Out")) {
            this.controller.logOut();
            this.setVisible(false);
        }
        else if (evt.getActionCommand().equals("FeedList")) {
            System.out.println(this.userId);
            this.controller.openFeedList(this.userId);
            this.setVisible(false);
        }

    }

    /**
     * Open this UI with given userId
     *
     * @param userId the current user id
     */
    @Override
    public void openHomePage(int userId) {
        this.userId = userId;
        this.setVisible(true);
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setController(HomePageController controller) {
        this.controller = controller;
    }
}
