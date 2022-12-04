package feed;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        JFrame application = new JFrame("Test");
        application.setSize(600, 600);
        application.setPreferredSize(new Dimension(600, 600));
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        FeedView view = new FeedView(null, null, 600, 600);
        screens.add(view, "FeedView");
        cardLayout.show(screens, "FeedView");
        application.pack();
        application.setVisible(true);
    }
}
