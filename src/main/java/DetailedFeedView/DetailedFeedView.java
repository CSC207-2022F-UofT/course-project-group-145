package DetailedFeedView;
import feed_interaction_use_case.CurrentSnippetController;
import feed_interaction_use_case.CurrentSnippetRequestModel;
import feed_interaction_use_case.LikeSnippetController;
import feed_interaction_use_case.NextSnippetController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DetailedFeedView extends JPanel implements ActionListener {
    LikeSnippetController likeSnippetController;
    NextSnippetController nextSnippetController;
    CurrentSnippetController currentSnippetController;
    String feedId;
    JButton likeButton;
    JButton nextButton;
    JLabel picture;

    public DetailedFeedView(String feedId, LikeSnippetController likeSnippetController, NextSnippetController nextSnippetController,
                            CurrentSnippetController currentSnippetController) throws IOException {
        this.feedId = feedId;
        this.nextSnippetController = nextSnippetController;
        this.likeSnippetController = likeSnippetController;
        this.currentSnippetController = currentSnippetController;
        this.likeButton = new JButton("Like");
        this.add(likeButton);
        this.nextButton = new JButton("Next");
        this.add(nextButton);
        // TODO: obtain the name of the picture.
        currentSnippetController.getCurrent(this.feedId);
        this.picture = new JLabel(new ImageIcon("Bucket/testPicture.jpeg"));
        this.add(picture);
        picture.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(new Color(200, 200, 100));
        likeButton.addActionListener(this);
        nextButton.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public DetailedFeedView(String feedId) throws IOException {
        this.feedId = feedId;
        this.likeButton = new JButton("Like");
        this.add(likeButton);
        this.nextButton = new JButton("Next");
        this.add(nextButton);
        // TODO: obtain the name of the picture.
        this.picture = new JLabel(new ImageIcon("Bucket/testPicture.jpeg"));
        this.add(picture);
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
            System.out.println("Like Button Was Pressed");
//            try {
//                likeSnippetController.like(this.feedId);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
        }else{
            System.out.println("Next Button Was Pressed");
//            try {
//                nextSnippetController.next(this.feedId);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }

        }
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("CodeR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setContentPane(new DetailedFeedView("44"));
        frame.setVisible(true);
    }
}
