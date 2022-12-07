import controller_presenter_gateway.chat_controller_presenter_gateway.*;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionOutputBoundary;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatListPresenter;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRepoGateway;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRepository;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedDSRepository;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedGatewayRequestModel;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedRepository;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.*;
import controller_presenter_gateway.hompage_controller_presenter.HomePageOutputBoundary;
import controller_presenter_gateway.hompage_controller_presenter.HomePagePresenter;
import controller_presenter_gateway.user_controller_presenter_gateway.*;
import entities.ChatFactory;
import entities.FeedFactory;
import entities.MessageFactory;

import ui.*;

import use_cases.chat_use_cases.*;
import use_cases.feed_interaction_use_case.CurrentSnippetUseCase;
import use_cases.feed_interaction_use_case.LikeSnippetUseCase;
import use_cases.feed_interaction_use_case.NextSnippetUseCase;
import use_cases.homepage_use_cases.OpenChatList;
import use_cases.homepage_use_cases.OpenChatListInputBoundary;
import use_cases.homepage_use_cases.OpenHomePage;
import use_cases.homepage_use_cases.OpenHomePageInputBoundary;


import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        JFrame application = new JFrame("App");
        DetailedFeedView view = new DetailedFeedView();

        FeedDSRepository feedDSRepository = new FeedRepository("feeds.json");
        CodeSnippetRepoGateway codeSnippetRepoGateway = new CodeSnippetRepository("snippets.json");
        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
        UserRepoGateway userRepoGateway = new UserRepository("user.json");

        Map<Integer, Integer> idToId = new HashMap<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        List<Integer> ids2 = new ArrayList<>();
        UserRepoRequestModel user1 = new UserRepoRequestModel(1, "bob", "joe", "blah@blah.com", idToId, ids, false);
        userRepoGateway.save(user1);
        UserRepoRequestModel user2 = new UserRepoRequestModel(2, "bob", "joe", "blah@blah.com", idToId, ids2, false);
        userRepoGateway.save(user2);
        UserRepoRequestModel user3 = new UserRepoRequestModel(3, "bob", "joe", "blah@blah.com", idToId, ids2, false);
        userRepoGateway.save(user3);
        UserRepoRequestModel user4 = new UserRepoRequestModel(4, "bob", "joe", "blah@blah.com", idToId, ids2, false);
        userRepoGateway.save(user4);
        UserRepoRequestModel user5 = new UserRepoRequestModel(5, "bob", "joe", "blah@blah.com", idToId, ids2, false);
        userRepoGateway.save(user5);

        codeSnippetRepoGateway.save(new CodeSnippetResponseModel(1, 2, "Code Snippet 1", "Bucket/testPicture.jpeg", new Date()));
        codeSnippetRepoGateway.save(new CodeSnippetResponseModel(2, 3, "Code Snippet 2", "Bucket/testPicture2.jpeg", new Date()));
        codeSnippetRepoGateway.save(new CodeSnippetResponseModel(3, 4, "Code Snippet 3", "Bucket/testPicture3.jpeg", new Date()));
        codeSnippetRepoGateway.save(new CodeSnippetResponseModel(4, 5, "Code Snippet 4", "Bucket/testPicture4.jpeg", new Date()));
        List<String> codeSnippets = new ArrayList<>();
        codeSnippets.add("1");
        codeSnippets.add("2");
        codeSnippets.add("3");
        codeSnippets.add("4");
        feedDSRepository.save(new FeedGatewayRequestModel(codeSnippets, new ArrayList<>(), new ArrayList<>(), -1, 1, "1"));

        DetailedFeedViewModel detailedFeedViewModel = new DetailedFeedViewModel();
        detailedFeedViewModel.addListener(view);

        NextSnippetPresenter nextSnippetPresenter = new NextSnippetPresenter(feedDSRepository, codeSnippetRepoGateway, detailedFeedViewModel);
        CurrentSnippetPresenter currentSnippetPresenter = new CurrentSnippetPresenter(feedDSRepository, codeSnippetRepoGateway, detailedFeedViewModel);
        CurrentSnippetUseCase currentSnippetUseCase = new CurrentSnippetUseCase(feedDSRepository, currentSnippetPresenter);
        NextSnippetUseCase nextSnippetUseCase = new NextSnippetUseCase(feedDSRepository, nextSnippetPresenter);

        CurrentSnippetController currentSnippetController1 = new CurrentSnippetController(currentSnippetUseCase);
        NextSnippetController nextSnippetController1 = new NextSnippetController(nextSnippetUseCase);

        view.setFeedId("1");
        view.setCurrentSnippetController(currentSnippetController1);
        view.setNextSnippetController(nextSnippetController1);
        view.setViewModel(detailedFeedViewModel);
        view.currentSnippetController.getCurrent("1");
        view.setVisible(true);

        HomePageView homePage = new HomePageView();
        HomePageOutputBoundary homePagePresenter = new HomePagePresenter(homePage);
        ChatListView chatListView = new ChatListView();
        ChatDeletionOutputBoundary chatDeletionOutputBoundary = new ChatListPresenter(chatListView, chatRepoGateway, userRepoGateway);
        OpenChatListInputBoundary openChatListInputBoundary = new OpenChatList(chatDeletionOutputBoundary);


        ChatView chat = new ChatView();
        ChatOutputBoundary chatPresenter = new ChatPresenter(chat, chatRepoGateway, messageRepoGateway);
        MessageFactory messageFactory = new MessageFactory();
        DeleteMessageInputBoundary delete = new DeleteMessage(chatPresenter, messageRepoGateway);
        SendMessageInputBoundary send = new SendMessage(messageFactory, chatPresenter, messageRepoGateway, chatRepoGateway);
        EditMessageInputBoundary edit = new EditMessage(chatPresenter, messageRepoGateway);
        OpenHomePageInputBoundary openHomePage = new OpenHomePage(homePagePresenter);
        ChatController chatController = new ChatController(delete, edit, send, openHomePage);
        chat.setController(chatController);

        FeedFactory feedFactory = new FeedFactory();
        ChatFactory chatFactory = new ChatFactory();
        LikeSnippetUseCase likeSnippetUseCase = new LikeSnippetUseCase(feedDSRepository, chatRepoGateway, codeSnippetRepoGateway, userRepoGateway, feedFactory, chatFactory, chatPresenter);
        LikeSnippetController likeSnippetController = new LikeSnippetController(likeSnippetUseCase);
        view.setLikeSnippetController(likeSnippetController);

        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        screens.add(view, "Feed");
        screens.add(chat, "Chat");
        application.add(screens);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(new Dimension(900, 900));
        application.setPreferredSize(new Dimension(900, 900));
        cardLayout.show(screens, "Feed");
        application.pack();
        application.setVisible(true);
    }

}
