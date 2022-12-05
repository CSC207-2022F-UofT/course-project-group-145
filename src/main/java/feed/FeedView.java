package feed;

import ui.ViewInterface;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.LineNumberInputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UI that shows the user a list of feeds, as well as providing the user an option to view each feed in detail,
 * or generate a new feed.
 * Implements ActionListener for user inputs
 * Implements ViewInterface, which is a custom interface to mimic the deprecated Observer interface.
 */
public class FeedView extends JPanel implements ActionListener, ViewInterface, ListSelectionListener {
    private FeedControllerInputBoundary controller;
    private FeedViewModel model;
    private JLabel title;
    private JButton generateNew;
    private JTextField tagInput;
    private JFormattedTextField lengthInput;
    private JList<String> feedList;
    private int userID;
    private int panelX;
    private int panelY;

    private List<Integer> feedIDs;
    private List<List<String>> feedTags;

    public FeedView(FeedControllerInputBoundary controller, FeedViewModel model, int sizeX, int sizeY){
        this.controller = controller;
        this.panelX = sizeX;
        this.panelY = sizeY;
        this.setSize(sizeX, sizeY);
        this.setLayout(null);
        draw();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.generateNew){
            String tagRaw = this.tagInput.getText();
            List<String> tags = Arrays.asList(tagRaw.strip().split(" "));
            FeedControllerInputModel model;
            if (this.lengthInput.getText() == null || this.lengthInput.getText().strip().equals("")){
                model = new FeedControllerInputModel(this.userID, tags);
            }
            else{
                int length = Integer.parseInt(this.lengthInput.getText());
                model = new FeedControllerInputModel(this.userID, tags);
            }

            controller.createNewFeed(model);
        }
    }

    /**
     * Listener for feedList JList
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = feedList.getSelectedIndex();
        int feedID = feedIDs.get(index);
        //TODO: Switch to Angel's screen
    }

    /**
     * Called whenever FeedViewModel is updated
     **/
    @Override
    public void update() {
        this.feedIDs = model.getIdList();
        this.feedTags = model.getTagList();
        this.draw();
    }

    private void draw(){
        this.title = new JLabel();
        this.title.setText("My Feeds:");
        this.title.setFont(new Font("Serif", Font.PLAIN, 20));
        this.title.setBounds(panelX/2-50, 10, 100, 50);
        this.add(this.title);

        this.generateNew = new JButton("Create new feed");
        generateNew.addActionListener(this);
        generateNew.setBounds(20,90,140, 30);
        this.add(this.generateNew);

        JLabel tagsLabel = new JLabel();
        tagsLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        tagsLabel.setText("Search Tags (separated by spaces)");
        tagsLabel.setBounds(180, 65, 100, 30);
        this.add(tagsLabel);

        this.tagInput = new JTextField();
        this.tagInput.setBounds(180, 90, 280, 30);
        this.add(this.tagInput);

        JLabel lengthLabel = new JLabel();
        lengthLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        lengthLabel.setText("Feed Length");
        lengthLabel.setBounds(480, 65, 350, 30);
        this.add(lengthLabel);

        this.lengthInput = new JFormattedTextField(NumberFormat.getInstance());
        this.lengthInput.setBounds(480, 90, 60, 30);
        this.lengthInput.setText("30");
        this.add(this.lengthInput);

        this.feedList = new JList<String>();
        this.feedList.setBounds(20, 120, panelX-40, panelY-140);
        this.feedList.setModel(new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return feedIDs.size();
            }

            @Override
            public String getElementAt(int index) {
                return feedIDs.get(index) + " " + feedTagsToList(index);
            }
        });
        this.feedList.addListSelectionListener(this);
    }

    /**
     * Returns the feedTags as a single String representation, with the feed's tags being represented as a word separated by spaces
     * @return A string that contains each of the feed's tags as words separated by spaces
     */
    private String feedTagsToList(int index){
        StringBuilder tagsString = new StringBuilder();
        for (String tag : feedTags.get(index)){
            tagsString.append(tag).append(" ");
        }
        return tagsString.toString().strip();
    }

    /**
     * Show fail window with message
     * @param failMsg
     */
    @Override
    public void reportFail(String failMsg) {
        new ErrFrame(failMsg);
    }

    private class ErrPanel extends JPanel{
        private ErrPanel(String message){
            this.setSize(400, 300);
            JTextArea area = new JTextArea(message);
            this.add(area);
            this.setVisible(true);
        }
    }

    private class ErrFrame extends JFrame{
        private ErrFrame(String message){
            ErrPanel panel = new ErrPanel(message);
            this.add(panel);
            this.setVisible(true);
        }
    }

    public void switchToThis(int userID){
        this.userID = userID;
        //need some kind of way to load feeds upon switch, maybe a view feeds use case?
        this.setVisible(true);
    }
}
