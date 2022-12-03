package ui;

import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatListController;

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
    private JPanel chats = new JPanel(new GridLayout(0, 1));
    private List<Object> listOfRows;
    private List<Integer> listOfOIds;
    private ChatListController chatListController;

    public ChatListView(int userId, Map<Integer, Integer> chatToUserIds) {
        this.userId = userId;
        chatIds = new ArrayList<Integer>(chatToUserIds.keySet());
        otherUserIds = new ArrayList<Integer>(chatToUserIds.values());

        initialize();
    }


    public void initialize() {
        JLabel listChat = new JLabel();
        listChat.setText("List of Chats");
        listChat.setVerticalAlignment(JLabel.TOP);
        listChat.setHorizontalAlignment(JLabel.CENTER);

        chats.setLayout(new GridLayout(chatIds.size(),2));
        chats.setBounds(0, 500, 200, 200);
        listOfRows = new ArrayList<Object>();
        listOfOIds = new ArrayList<Integer>();

        for (int index = 0; index < chatIds.size(); index++) {
            JPanel row = new JPanel();
            JLabel user = new JLabel();
            listOfOIds.add(otherUserIds.get(index));
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
            row.add(user);
            row.add(openButton);
            row.add(deleteButton);
            listOfRows.add(row);
            chats.add(row);
        }


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 750, 750);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(listChat);
        panel.add(chats);
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] s = e.getActionCommand().split("\\s");
        int uId = Integer.parseInt(s[1]);
        int cId = Integer.parseInt(s[3]);
        int oId = Integer.parseInt(s[2]);
        if (e.getActionCommand().startsWith("Delete")) {
            int x = 0;
            for (Integer i : listOfOIds) {
                if (i == oId) {
                    try {
                        this.delete(uId, cId, oId, x);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                x++;
            }



        }
        else if (e.getActionCommand().startsWith("Open")) {
            try {
                this.openChat(uId, cId, oId);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    public void setListController(ChatListController chatListController) {
        this.chatListController = chatListController;
    }

    @Override
    public void delete(int userId, int chatId, int otherUserId, int x) throws IOException {
        //delete in ui
        Object row = listOfRows.get(x);
        JPanel toRemove = (JPanel) row;
        toRemove.setVisible(false);

        //have to figure out how to call the controller do really delete. ASK BobJoe OUR GOD AND SAVIOUR.
        chatListController.delete(chatId);

    }

    @Override
    public void openChat(int userId, int chatId, int otherUserId) throws IOException {
        //hide ui
        this.setVisible(false);
        //open the new chat howwwwwwwwwww, explain to me BOBJOE
        chatListController.openChat(chatId, userId, otherUserId);
    }

    @Override
    public void failView(String message) {
    }
}
