package ui;

import controller_presenter_gateway.chat_controller_presenter_gateway.*;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionOutputBoundary;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatListController;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatListPresenter;
import entities.MessageFactory;
import use_cases.chat_use_cases.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChatListViewUsageDemo {

    public static void main(String[] args) throws IOException {
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
        chatToUserIds.put(18, 22);
        chatToUserIds.put(0, 0);
        ChatListView chatListView = new ChatListView(userId, chatToUserIds);
        frame.add(chatListView);

//        ChatView view = new ChatView();
//        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
//        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
//        ChatOutputBoundary presenter = new ChatPresenter(view, chatRepoGateway, messageRepoGateway);
//        MessageFactory factory = new MessageFactory();
//        DeleteMessageInputBoundary delete = new DeleteMessage(presenter, messageRepoGateway);
//        SendMessageInputBoundary send = new SendMessage(factory, presenter, messageRepoGateway, chatRepoGateway);
//        EditMessageInputBoundary edit = new EditMessage(presenter, messageRepoGateway);
//        ChatController controller = new ChatController(delete, edit, send);
//        view.setController(controller);

        ChatView view = new ChatView();
        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
        ChatOutputBoundary presenter = new ChatPresenter(view, chatRepoGateway, messageRepoGateway);
        ChatDeletionOutputBoundary presenter2 = new ChatListPresenter(chatListView, chatRepoGateway);
        DeleteChatInputBoundary deleteChat = new DeleteChat(presenter2, chatRepoGateway);
        OpenChatInputBoundary openChat = new OpenChat(presenter);
        ChatListController listController = new ChatListController(deleteChat, openChat);
        chatListView.setListController(listController);

        frame.setVisible(true);

    }
}