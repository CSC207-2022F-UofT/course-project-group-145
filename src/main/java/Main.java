
import controller_presenter_gateway.chat_controller_presenter_gateway.*;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionOutputBoundary;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatListController;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatListPresenter;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRepoGateway;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRepository;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;
import controller_presenter_gateway.feed_controller_presenter_gateway.*;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.*;
import controller_presenter_gateway.hompage_controller_presenter.HomePageController;
import controller_presenter_gateway.hompage_controller_presenter.HomePageOutputBoundary;
import controller_presenter_gateway.hompage_controller_presenter.HomePagePresenter;
import controller_presenter_gateway.user_controller_presenter_gateway.*;
import entities.*;
import ui.*;
import use_cases.chat_list_use_cases.DeleteChat;
import use_cases.chat_list_use_cases.DeleteChatInputBoundary;
import use_cases.chat_list_use_cases.OpenChat;
import use_cases.chat_list_use_cases.OpenChatInputBoundary;
import use_cases.chat_use_cases.*;
import use_cases.feed_interaction_use_case.CurrentSnippetUseCase;
import use_cases.feed_interaction_use_case.LikeSnippetUseCase;
import use_cases.feed_interaction_use_case.NextSnippetUseCase;
import use_cases.feed_use_case.CreateFeedUseCase;
import use_cases.feed_use_case.CreateFeedUseCaseInputBoundary;
import use_cases.feed_use_case.OpenFeedListInputBoundary;
import use_cases.feed_use_case.OpenFeedListUseCase;
import use_cases.homepage_use_cases.OpenChatList;
import use_cases.homepage_use_cases.OpenChatListInputBoundary;
import use_cases.homepage_use_cases.OpenHomePage;
import use_cases.homepage_use_cases.OpenHomePageInputBoundary;
import use_cases.user_use_case.AddUser;
import use_cases.user_use_case.AddUserInputBoundary;
import use_cases.user_use_case.Login;
import use_cases.user_use_case.LoginInputBoundary;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // this is for set up for a demo
        ChatRepository chatRepo = new ChatRepository("chat.json");
        List<Integer> ids = new ArrayList<>();
        ids.add(0);
        ids.add(1);
        List<Integer> ids1 = new ArrayList<>();
        ids1.add(2);
        ids1.add(3);
        chatRepo.save(new ChatRepoRequestModel(0, ids, false));
        chatRepo.save(new ChatRepoRequestModel(1, ids1, false));

        UserRepoGateway userRepo = new UserRepository("user.json");
        Map<Integer, Integer> idToId0 = new HashMap<>();
        idToId0.put(0, 1);
        idToId0.put(1, 2);
        UserRepoRequestModel user = new UserRepoRequestModel(0, "bob", "joe", "blah@blah.com", idToId0, new ArrayList<>(), false);
        userRepo.save(user);
        Map<Integer, Integer> idToId1 = new HashMap<>();
        idToId1.put(0, 0);
        UserRepoRequestModel user1 = new UserRepoRequestModel(1, "tim", "smith", "blah@blah.com", idToId1, new ArrayList<>(), false);
        userRepo.save(user1);
        Map<Integer, Integer> idToId2 = new HashMap<>();
        idToId2.put(1, 0);
        UserRepoRequestModel user2 = new UserRepoRequestModel(2, "sam", "yo", "blah@blah.com", idToId2, new ArrayList<>(), false);
        userRepo.save(user2);

        MessageRepoGateway messageGateway = new MessageRepository("message.json");
        MessageRepoRequestModel message = new MessageRepoRequestModel(0, "hello", 0, 1, new Date(), new Date(), false, false, false , -1);
        messageGateway.save(message);
        MessageRepoRequestModel message1 = new MessageRepoRequestModel(1, "hello there", 1, 0, new Date(), new Date(), false, false, false , -1);
        messageGateway.save(message1);
        MessageRepoRequestModel message2 = new MessageRepoRequestModel(2, "hi", 0, 2, new Date(), new Date(), false, false, false , -1);
        messageGateway.save(message2);
        MessageRepoRequestModel message3 = new MessageRepoRequestModel(3, "bonjour", 2, 0, new Date(), new Date(), false, false, false , -1);
        messageGateway.save(message3);

        FeedDSRepository feedGateway = new FeedRepository("feeds.json");
        CodeSnippetRepoGateway codeSnippetRepoGateway = new CodeSnippetRepository("snippets.json");
        codeSnippetRepoGateway.save(new CodeSnippetResponseModel(1, 2, "Code Snippet 1", "Bucket/testPicture.jpeg", new Date()));
        codeSnippetRepoGateway.save(new CodeSnippetResponseModel(2, 1, "Code Snippet 2", "Bucket/testPicture2.jpeg", new Date()));
        codeSnippetRepoGateway.save(new CodeSnippetResponseModel(3, 0, "Code Snippet 3", "Bucket/testPicture3.jpeg", new Date()));
        codeSnippetRepoGateway.save(new CodeSnippetResponseModel(4, 2, "Code Snippet 4", "Bucket/testPicture4.jpeg", new Date()));

        FeedFactory feedFactory = new FeedFactory();
        ChatFactory chatFactory = new ChatFactory();

        JFrame application = new JFrame("CodeR");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(600, 600);
        application.setPreferredSize(new Dimension(600, 600));
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

//        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
//        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
//        UserRepoGateway userRepoGateway = new UserRepository("user.json");





        LoginView login = new LoginView();
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(login);

        FeedViewModel feedListViewModel = new FeedViewModel();
        CreateFeedOutputBoundary createFeedPresenter = new CreateFeedPresenter(feedListViewModel, feedGateway, userRepo);

        HomePageView homePage = new HomePageView();
        HomePageOutputBoundary homePagePresenter = new HomePagePresenter(homePage);
        ChatListView chatListView = new ChatListView();
        ChatDeletionOutputBoundary chatDeletionOutputBoundary = new ChatListPresenter(chatListView, chatRepo, userRepo);
        OpenChatListInputBoundary openChatListInputBoundary = new OpenChatList(chatDeletionOutputBoundary);
        OpenFeedListInputBoundary openFeedListInputBoundary = new OpenFeedListUseCase(createFeedPresenter);
        HomePageController homePageController = new HomePageController(openChatListInputBoundary, loginOutputBoundary, openFeedListInputBoundary);
        OpenHomePageInputBoundary openHomePage = new OpenHomePage(homePagePresenter);
        homePage.setController(homePageController);

        RegisterView register = new RegisterView();
        RegisterOutputBoundary registerOutputBoundary = new RegisterPresenter(register);
        LoginInputBoundary loginInputBoundary = new Login(userRepo, homePagePresenter);
        LoginController loginController = new LoginController(loginInputBoundary, registerOutputBoundary);
        login.setController(loginController);
        UserFactory userFactory = new UserFactory();
        AddUserInputBoundary addUserInputBoundary = new AddUser(userFactory, homePagePresenter, userRepo);
        UserController userController = new UserController(addUserInputBoundary);
        register.setController(userController);

        ChatView chat = new ChatView();
        ChatOutputBoundary chatPresenter = new ChatPresenter(chat, chatRepo, messageGateway);
        MessageFactory messageFactory = new MessageFactory();
        DeleteMessageInputBoundary delete = new DeleteMessage(chatPresenter, messageGateway);
        SendMessageInputBoundary send = new SendMessage(messageFactory, chatPresenter, messageGateway, chatRepo);
        EditMessageInputBoundary edit = new EditMessage(chatPresenter, messageGateway);

        ChatController chatController = new ChatController(delete, edit, send, openHomePage);

        DeleteChatInputBoundary deleteChat = new DeleteChat(chatDeletionOutputBoundary, chatRepo);
        OpenChatInputBoundary openChat = new OpenChat(chatPresenter);
        ChatListController chatListController = new ChatListController(deleteChat, openChat, openHomePage);
        chatListView.setListController(chatListController);
        chat.setController(chatController);

        DetailedFeedView detailedFeedView = new DetailedFeedView();
        DetailedFeedViewModel detailedFeedViewModel = new DetailedFeedViewModel();
        detailedFeedView.setViewModel(detailedFeedViewModel);
        detailedFeedViewModel.addListener(detailedFeedView);
        detailedFeedView.setHomeController(new FeedInteractionHomeController(openHomePage));

        NextSnippetPresenter nextSnippetPresenter = new NextSnippetPresenter(feedGateway, codeSnippetRepoGateway, detailedFeedViewModel);
        CurrentSnippetPresenter currentSnippetPresenter = new CurrentSnippetPresenter(feedGateway, codeSnippetRepoGateway, detailedFeedViewModel);
        CurrentSnippetUseCase currentSnippetUseCase = new CurrentSnippetUseCase(feedGateway, currentSnippetPresenter);
        NextSnippetUseCase nextSnippetUseCase = new NextSnippetUseCase(feedGateway, nextSnippetPresenter);
        CurrentSnippetController currentSnippetController = new CurrentSnippetController(currentSnippetUseCase);
        NextSnippetController nextSnippetController = new NextSnippetController(nextSnippetUseCase);
        detailedFeedView.setCurrentSnippetController(currentSnippetController);
        detailedFeedView.setNextSnippetController(nextSnippetController);
        LikeSnippetUseCase likeSnippetUseCase = new LikeSnippetUseCase(feedGateway, chatRepo, codeSnippetRepoGateway, userRepo, feedFactory, chatFactory, chatPresenter);
        LikeSnippetController likeSnippetController = new LikeSnippetController(likeSnippetUseCase);
        detailedFeedView.setLikeSnippetController(likeSnippetController);

        CreateFeedUseCaseInputBoundary createFeedUseCase = new CreateFeedUseCase(createFeedPresenter, feedGateway, codeSnippetRepoGateway, userRepo, new TagFactory(), feedFactory, new CodeSnippetFactory());
        FeedControllerInputBoundary createFeedController = new CreateFeedController(createFeedUseCase, openHomePage, currentSnippetUseCase);
        FeedView feedListView = new FeedView(createFeedController, feedListViewModel, 600, 600);
        feedListViewModel.addListener(feedListView);








        screens.add(homePage, "Home");
        screens.add(chatListView, "Chat List");
        screens.add(register, "Register");
        screens.add(login, "Login");
        screens.add(detailedFeedView, "Detailed Feed View");
        screens.add(feedListView, "Feed List View");
        screens.add(chat, "Chat");
        cardLayout.show(screens, "Login");

        application.pack();
        application.setVisible(true);



    }

}
