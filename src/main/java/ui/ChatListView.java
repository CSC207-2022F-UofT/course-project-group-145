package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class ChatListView extends JPanel implements ChatListViewInterface, ActionListener {
//    private final JTextArea textArea = new JTextArea(5, 20);
//
//    private ChatController controller;
//
//    private final JPanel messages = new JPanel();
//
//    private final JScrollPane scroll = new JScrollPane(messages, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
//            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//
//    private int chatId;
//
//    private int userId;
//
//    private int otherUser;
//
//    private int numChat = 0;

    private int userId;
    private JFrame j1;
    private List<Integer> chatIds;
    private List<Integer> otherUserIds;
    private final JTextArea textArea = new JTextArea(5, 20);
    private final JPanel users = new JPanel();
//    private JFrame frame = new JFrame();
    private JPanel chats = new JPanel(new GridLayout(0, 1));

    public ChatListView(int userId, Map<Integer, Integer> chatToUserIds) {
        this.userId = userId;
        chatIds = new ArrayList<Integer>(chatToUserIds.keySet());
        otherUserIds = new ArrayList<Integer>(chatToUserIds.values());

        initialize();

//        JLabel title = new JLabel("List of Chats");
//        messages.setLayout(new BoxLayout(messages, BoxLayout.Y_AXIS));
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//        JPanel message = new JPanel();
//        message.add(new JLabel("Message"));
//        message.add(textArea);
//        JButton send = new JButton("Send");
//        JPanel buttons = new JPanel();
//        buttons.add(send);
//        send.addActionListener(this);
//        send.setActionCommand("Send");
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(title);
//        this.add(scroll);
//        this.add(message);
//        this.add(buttons);
    }


    public void initialize() {
        JLabel listChat = new JLabel();
        listChat.setText("List of Chats");
        listChat.setVerticalAlignment(JLabel.TOP);
        listChat.setHorizontalAlignment(JLabel.CENTER);

        users.setLayout(new BoxLayout(users, BoxLayout.Y_AXIS));

////        List<JButton> buttons = new ArrayList<>();
//        JPanel chats = new JPanel( new GridLayout(0, 1) );
        chats.setLayout(new GridLayout(chatIds.size(),2));
        chats.setBounds(0, 500, 200, 200);

        for (int index = 0; index < chatIds.size(); index++) {
            JPanel row = new JPanel();
            JLabel user = new JLabel();
            user.setText(String.valueOf(otherUserIds.get(index)));
            JButton deleteButton = new JButton();
            deleteButton.setText("Delete");
            deleteButton.setBounds(0, (index)*5+100, 1, 1);
            deleteButton.addActionListener(this);
            deleteButton.setActionCommand("Delete "+ userId +" " + otherUserIds.get(index) +" " +chatIds.get(index));
            JButton openButton = new JButton();
            openButton.setText("Open");
            openButton.setBounds(0, (index)*5+100, 1, 1);
            openButton.addActionListener(this);
            openButton.setActionCommand("Open "+ userId +" " + otherUserIds.get(index) +" " +chatIds.get(index));
            //add(button);
            row.add(user);
            row.add(openButton);
            row.add(deleteButton);
            chats.add(row);
//            buttons.add(button);
        }


        JPanel panel = new JPanel();
        panel.setBounds(0, 100, 750, 650);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());
//        frame.setSize(750, 750);
//        frame.setLocationRelativeTo(null);

        panel.add(listChat);
        panel.add(chats);
//        frame.add(panel);
//        this.add(frame);
        this.add(panel);

//        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().startsWith("Delete")) {
            String[] s = e.getActionCommand().split("\\s");
            int UId = Integer.parseInt(s[1]);
            int CId = Integer.parseInt(s[3]);
            int OId = Integer.parseInt(s[2]);
            for (Component c : chats.getComponents()) {
                if (c instanceof JLabel) {
                    String local = ((JLabel) c).getText();
                    if (Integer.parseInt(local) == OId) {
                        //delete component


                        // call delete

                    }
                }
            }

            //first call delete to repository

        }
        else if (e.getActionCommand().startsWith("Open")) {
            //just hide and call open
            this.setVisible(false);
            //call open
        }

    }
}
