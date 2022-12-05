package DetailedFeedView;
import UI.ViewInterface;
import feed_interaction_use_case.CurrentSnippetController;
import feed_interaction_use_case.LikeSnippetController;
import feed_interaction_use_case.NextSnippetController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DetailedFeedView extends JPanel implements ActionListener, ViewInterface {
    LikeSnippetController likeSnippetController;
    NextSnippetController nextSnippetController;
    CurrentSnippetController currentSnippetController;
    DetailedFeedViewModel viewModel;
    String feedId;
    JButton likeButton;
    JButton nextButton;
    JLabel picture;
    JLabel errorLabel;

    public DetailedFeedView(String feedId, LikeSnippetController likeSnippetController, NextSnippetController nextSnippetController,
                            CurrentSnippetController currentSnippetController) throws IOException {
        this.feedId = feedId;
        this.viewModel = new DetailedFeedViewModel();
        this.viewModel.addListener(this);
        this.nextSnippetController = nextSnippetController;
        this.likeSnippetController = likeSnippetController;
        this.currentSnippetController = currentSnippetController;
        this.likeButton = new JButton("Like");
        this.add(likeButton);
        this.nextButton = new JButton("Next");
        this.add(nextButton);
        this.picture = new JLabel();
        draw();
        picture.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(new Color(200, 200, 100));
        likeButton.addActionListener(this);
        nextButton.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getText();
        if(label=="Like"){
            try {
                likeSnippetController.like(this.feedId);
                this.setVisible(false);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            try {
                nextSnippetController.next(this.feedId);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    @Override
    public void update() {
        String location = viewModel.getSnippetLocation();
        this.picture.setIcon(new ImageIcon(location));
    }

    public void draw() throws IOException {
        this.open();
        this.add(picture);
    }

    public void open() throws IOException {
        currentSnippetController.getCurrent(feedId);
    }

    @Override
    public void reportFail(String errMsg) {
        errorLabel = new JLabel(errMsg);
        remove(likeButton);
        remove(nextButton);
        remove(picture);
        add(errorLabel);
    }
}
