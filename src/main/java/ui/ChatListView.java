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

/**
 * UI written in Java Swing that displays a list of chats owned by the user
 */
public class ChatListView extends JPanel implements ChatListViewInterface, ActionListener {

    private int userId;
    private List<Integer> chatIds;
    private List<Integer> otherUserIds;
    private JPanel chats = new JPanel(new GridLayout(0, 1));
    private List<Object> listOfRows;
    private List<Integer> listOfOIds;
    private ChatListController chatListController;

    public ChatListView() {
        this.userId = -1;
        chatIds = new ArrayList<>();
        otherUserIds = new ArrayList<>();

        initialize();
    }

    /**
     * Calls the private initialize() method to initialize a new chat list based on the parameters UserId, and
     * ChatToUserIds.
     *
     * @param userId is an int referring to the user id of the user that is logged in.
     * @param chatToUserIds is a map from an Integer that is a chat id to an Integer that is a user id of the other
     *                      user in the chat with chat id.
     */
    public void openChatList(int userId, Map<Integer, Integer> chatToUserIds) {
        Component[] components = this.getComponents();
        for (Component c : components) {
            this.remove(c);
        }
        chats = new JPanel(new GridLayout(0, 1));

        this.userId = userId;
        chatIds = new ArrayList<>(chatToUserIds.keySet());
        otherUserIds = new ArrayList<>(chatToUserIds.values());

        initialize();
        this.setVisible(true);
    }


    private void initialize() {
        JLabel listChat = new JLabel();
        listChat.setText("List of Chats");
        listChat.setVerticalAlignment(JLabel.TOP);
        listChat.setHorizontalAlignment(JLabel.CENTER);

        chats.setLayout(new GridLayout(chatIds.size(),2));
        chats.setBounds(0, 500, 200, 200);
        listOfRows = new ArrayList<>();
        listOfOIds = new ArrayList<>();

        int p = 0;
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
            p = index;
        }
        JButton backButton = new JButton();
        backButton.setText("Back");
        backButton.setBounds(0, (p*5)+100, 1, 1);
        backButton.addActionListener(this);
        backButton.setActionCommand("Back");
        JPanel row = new JPanel();
        row.add(backButton);
        chats.add(row);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 750, 750);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(listChat);
        panel.add(chats);
        this.add(panel);
    }

    /**
     * Takes in event e that is generated by clicking a button and according to the button clicked performs the
     * appropriate action.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().startsWith("Delete")) {
            String[] s = e.getActionCommand().split("\\s");
            int uId = Integer.parseInt(s[1]);
            int cId = Integer.parseInt(s[3]);
            int oId = Integer.parseInt(s[2]);
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
            String[] s = e.getActionCommand().split("\\s");
            int uId = Integer.parseInt(s[1]);
            int cId = Integer.parseInt(s[3]);
            int oId = Integer.parseInt(s[2]);
            try {
                this.openChat(uId, cId, oId);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        else if (e.getActionCommand().startsWith("Back")) {
            try {
                this.goHome();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    /**
     * Sets the ChatListController for the ChatListView.
     *
     * @param chatListController passes an OpenChatListController Object.
     */
    public void setListController(ChatListController chatListController) {
        this.chatListController = chatListController;
    }

    /**
     * Deletes the chat selected by clicking the delete button in the ChatListView.
     *
     * @param userId is the int of the user id of the user logged in.
     * @param chatId is the int of the chat id to be deleted.
     * @param otherUserId is the int of the other user part of the chat
     * @param x is an int which is the index that signifies the row in listOfRows which needs to be removed in the
     *          ChatListView.
     * @throws IOException if an error is found when running the code.
     */
    @Override
    public void delete(int userId, int chatId, int otherUserId, int x) throws IOException {
        //delete in ui
        Object row = listOfRows.get(x);
        JPanel toRemove = (JPanel) row;
        toRemove.setVisible(false);

        chatListController.delete(chatId);

    }

    /**
     * Opens the chat selected by clicking the open button in the ChatListView.
     *
     * @param userId is the int of the user id of the user logged in.
     * @param chatId is the int of the chat id to be opened.
     * @param otherUserId is the int of the other user part of the chat
     * @throws IOException if an error is found when running the code.
     */
    @Override
    public void openChat(int userId, int chatId, int otherUserId) throws IOException {
        //hide ui
        this.setVisible(false);
        chatListController.openChat(chatId, userId, otherUserId);
    }

    /**
     * Goes to the HomePage when the back button is clicked in the ChatListView.
     *
     * @throws IOException if an error is found when running the code.
     */
    @Override
    public void goHome() throws IOException {
        this.setVisible(false);
        this.chatListController.openHomePage(this.userId);
    }

    /**
     * Takes the appropriate action in case there is an error in an action performed in the UI.
     *
     * @param message is the message passed in based on the error thrown while performing an action in the UI.
     */
    @Override
    public void failView(String message) {
    }
}
