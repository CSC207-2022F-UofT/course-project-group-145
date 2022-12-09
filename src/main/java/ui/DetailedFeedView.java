package ui;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.CurrentSnippetController;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.FeedInteractionHomeController;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.LikeSnippetController;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.NextSnippetController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Java swing UI that allows the user to view the code snippets inside of the feed
 * user can swipe thorugh  code snippets, and can like them, which will bring up a chat with the author of code snippet
 */
public class DetailedFeedView extends JPanel implements ActionListener, ViewInterface {
    LikeSnippetController likeSnippetController;
    NextSnippetController nextSnippetController;
    FeedInteractionHomeController homeController;
    public CurrentSnippetController currentSnippetController;
    private int userID;
    DetailedFeedViewModel viewModel;
    String feedId;
    JButton likeButton;
    JButton nextButton;
    private JButton homeButton;
    JLabel picture;
    JLabel errorLabel;

    /**
     * Initialises a new DetailedFeedView
     * @throws IOException
     */
    public DetailedFeedView() throws IOException {
        this.likeButton = new JButton("Like");
        this.add(likeButton);
        this.nextButton = new JButton("Next");
        this.add(nextButton);
        this.picture = new JLabel();
        this.add(picture);
        this.homeButton = new JButton("Home");
        this.add(homeButton);
        picture.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.addActionListener(this);
        likeButton.addActionListener(this);
        nextButton.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public void setLikeSnippetController(LikeSnippetController likeSnippetController){
        this.likeSnippetController = likeSnippetController;
    }

    public void setNextSnippetController(NextSnippetController nextSnippetController){
        this.nextSnippetController = nextSnippetController;
    }
    public void setHomeController(FeedInteractionHomeController homeController){
        this.homeController = homeController;
    }

    public void setCurrentSnippetController(CurrentSnippetController currentSnippetController){
        this.currentSnippetController = currentSnippetController;
    }
    
    public void setViewModel(DetailedFeedViewModel detailedFeedViewModel){
        this.viewModel = detailedFeedViewModel;
        detailedFeedViewModel.addListener(this);
    }
    /**
     * Method called by the elements of this UI whenever a user performs an action
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.likeButton){
            try {
                likeSnippetController.like(this.feedId);
                this.setVisible(false);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() == this.nextButton){
            try {
                nextSnippetController.next(this.feedId);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() == this.homeButton){
            this.homeController.goHome(this.userID);
            this.setVisible(false);
        }

    }

    /**
     * Method called by view model to update this UI
     */
    @Override
    public void update() {
        this.feedId = String.valueOf(viewModel.getFeedId());
        String location = viewModel.getSnippetLocation();
        this.picture.setIcon(new ImageIcon(location));
        this.repaint();
        this.revalidate();
        this.setVisible(true);
    }

    /**
     * Applies an error message to this ui
     * @param errMsg message to display to user
     */
    @Override
    public void reportFail(String errMsg) {
        errorLabel = new JLabel(errMsg);
        this.removeAll();
        this.repaint();
        errorLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(errorLabel);
        this.homeButton = new JButton("Home");
        homeButton.addActionListener(this);
        this.add(homeButton);
        this.revalidate();
    }


}
