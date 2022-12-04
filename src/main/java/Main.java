
import controller_presenter_gateway.chat_controller_presenter_gateway.*;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionOutputBoundary;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatListController;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatListPresenter;
import controller_presenter_gateway.hompage_controller_presenter.HomePageController;
import controller_presenter_gateway.hompage_controller_presenter.HomePageOutputBoundary;
import controller_presenter_gateway.hompage_controller_presenter.HomePagePresenter;
import entities.MessageFactory;
import ui.ChatListView;
import ui.ChatView;
import ui.HomePageView;
import use_cases.chat_list_use_cases.DeleteChat;
import use_cases.chat_list_use_cases.DeleteChatInputBoundary;
import use_cases.chat_list_use_cases.OpenChat;
import use_cases.chat_list_use_cases.OpenChatInputBoundary;
import use_cases.chat_use_cases.*;
import use_cases.homepage_use_cases.OpenChatList;
import use_cases.homepage_use_cases.OpenChatListInputBoundary;
import use_cases.homepage_use_cases.OpenHomePage;
import use_cases.homepage_use_cases.OpenHomePageInputBoundary;

import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        // this is to set up something to demo, comment out later
        ChatRepository chatRepo = new ChatRepository("chat.json");
        List<Integer> ids = new ArrayList<>();
        ids.add(0);
        ids.add(1);

        chatRepo.save(new ChatRepoRequestModel(0, ids, false));

        MessageRepoGateway messageGateway = new MessageRepository("message.json");
        MessageRepoRequestModel message = new MessageRepoRequestModel(0, "hello", 0, 1, new Date(), new Date(), false, false, false , -1);
        messageGateway.save(message);
        MessageRepoRequestModel message1 = new MessageRepoRequestModel(1, "hello there", 1, 0, new Date(), new Date(), false, false, false , -1);
        messageGateway.save(message1);

        JFrame application = new JFrame("CodeR");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(600, 600);
        application.setPreferredSize(new Dimension(600, 600));
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");

        HomePageView homePage = new HomePageView();
        HomePageOutputBoundary homePagePresenter = new HomePagePresenter(homePage);
        ChatListView chatListView = new ChatListView(0, new HashMap<>());
        ChatDeletionOutputBoundary chatDeletionOutputBoundary = new ChatListPresenter(chatListView, chatRepoGateway);
        OpenChatListInputBoundary openChatListInputBoundary = new OpenChatList(chatDeletionOutputBoundary);
        HomePageController homePageController = new HomePageController(openChatListInputBoundary);
        homePage.setController(homePageController);


        ChatView chat = new ChatView();
        ChatOutputBoundary chatPresenter = new ChatPresenter(chat, chatRepoGateway, messageRepoGateway);
        MessageFactory messageFactory = new MessageFactory();
        DeleteMessageInputBoundary delete = new DeleteMessage(chatPresenter, messageRepoGateway);
        SendMessageInputBoundary send = new SendMessage(messageFactory, chatPresenter, messageRepoGateway, chatRepoGateway);
        EditMessageInputBoundary edit = new EditMessage(chatPresenter, messageRepoGateway);
        OpenHomePageInputBoundary openHomePage = new OpenHomePage(homePagePresenter);
        ChatController chatController = new ChatController(delete, edit, send, openHomePage);
        chat.setController(chatController);

        screens.add(chat, "Chat");
        screens.add(homePage, "Home");
        cardLayout.show(screens, "Chat");
        application.pack();
        application.setVisible(true);



    }

}
