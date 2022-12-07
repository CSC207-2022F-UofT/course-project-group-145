package UI;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.CurrentSnippetController;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.LikeSnippetController;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.NextSnippetController;


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

    public DetailedFeedView() throws IOException {
        this.likeButton = new JButton("Like");
        this.add(likeButton);
        this.nextButton = new JButton("Next");
        this.add(nextButton);
        this.picture = new JLabel();
        this.add(picture);
        picture.setAlignmentX(Component.CENTER_ALIGNMENT);
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

    public void setCurrentSnippetController(CurrentSnippetController currentSnippetController){
        this.currentSnippetController = currentSnippetController;
    }
    
    public void setViewModel(DetailedFeedViewModel detailedFeedViewModel){
        this.viewModel = detailedFeedViewModel;
        detailedFeedViewModel.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getText();
        if(label.equals("Like")){
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
        this.revalidate();
    }

    @Override
    public void reportFail(String errMsg) {
        errorLabel = new JLabel(errMsg);
        this.removeAll();
        this.repaint();
        errorLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(errorLabel);
        this.revalidate();
    }
}
