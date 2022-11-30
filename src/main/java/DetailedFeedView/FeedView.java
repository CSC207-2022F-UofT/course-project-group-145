package DetailedFeedView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedView {
    private JButton LikeButton;
    private JButton NextButton;
    private JPanel panelMain;
    private JLabel Picture;

    public FeedView() {

        ImageIcon pic = new ImageIcon("testPicture.jpeg");
        Picture.setIcon(pic);

        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CodeR");
        frame.setContentPane(new FeedView().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
