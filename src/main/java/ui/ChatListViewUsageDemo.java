package ui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ChatListViewUsageDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);


        int userId = 1;
        Map chatToUserIds = new HashMap<Integer, Integer>();
        chatToUserIds.put(1,10);
        chatToUserIds.put(2,20);
        chatToUserIds.put(3,30);
        ChatListView chatListView = new ChatListView(userId, chatToUserIds);
        frame.add(chatListView);
        frame.setVisible(true);

    }
}