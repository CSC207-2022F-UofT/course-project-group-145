package use_cases.feed_interaction_use_case;


import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRepoGateway;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatOutputBoundary;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepoGateway;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepoRequestModel;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;
import entities.Chat;
import entities.ChatFactory;
import entities.FeedFactory;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedDSRepository;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedGatewayResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Use case to allow user to like a code snippet. This will also open a chat between the 2 users.
 */
public class LikeSnippetUseCase implements LikeSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final ChatRepoGateway chatRepoGateway;
    final CodeSnippetRepoGateway codeSnippetRepoGateway;
    final UserRepoGateway userRepoGateway;
    final FeedFactory feedFactory;
    final ChatFactory chatFactory;
    final ChatOutputBoundary chatOutputBoundary;


    /**
     * Create a new LikeSnippetUseCase
     * @param feedDSRepository feed repository
     * @param chatRepoGateway chat repository
     * @param codeSnippetRepoGateway code snippet repository
     * @param userRepoGateway user repository
     * @param feedFactory instance of feed factory
     * @param chatFactory instance of chat factory
     * @param chatOutputBoundary instance of chatOutputBoundary (to open chat view when user likes snippet)
     */
    public LikeSnippetUseCase(FeedDSRepository feedDSRepository, ChatRepoGateway chatRepoGateway, CodeSnippetRepoGateway codeSnippetRepoGateway, UserRepoGateway userRepoGateway, FeedFactory feedFactory, ChatFactory chatFactory, ChatOutputBoundary chatOutputBoundary) {
        this.feedDSRepository = feedDSRepository;
        this.chatRepoGateway = chatRepoGateway;
        this.codeSnippetRepoGateway = codeSnippetRepoGateway;
        this.userRepoGateway = userRepoGateway;
        this.feedFactory = feedFactory;
        this.chatFactory = chatFactory;
        this.chatOutputBoundary = chatOutputBoundary;
    }

    /**
     * This method likes the current snippet of the feed represented by the request model. We obtain the current
     * snippet by the variable curr in the request model. Then we trigger a call to the gateway so that we update
     * our repository with the new list of matched snippet IDs. Lastly, I create a chat between the two users and
     * make a call to the Chat presenter.
     * @param likeSnippetRequestModel this request model contains all the required information to match the owner of
     *                                the feed to the owner of the current code snippet in the feed.
     * @throws IOException this is thrown in case the feed does not exist.
     */
    @Override
    public void like(LikeSnippetRequestModel likeSnippetRequestModel) throws IOException {

        FeedGatewayResponseModel feed = feedDSRepository.load(likeSnippetRequestModel.getFeedId());

        Chat.setNumChat(chatRepoGateway.getNumChats());
        List<Integer> emptyList = new ArrayList<>();
        Chat newChat = chatFactory.create(emptyList);
        int chatID = newChat.getChatId();
        ChatRepoRequestModel chatRepoRequestModel = new ChatRepoRequestModel(chatID, emptyList, false);

        int thisUser = feed.getUserId();
        String currentSnippetId = feed.getSnippetIDs().get(feed.getCurr()+1);
        CodeSnippetResponseModel codeSnippetRequestModel = codeSnippetRepoGateway.retrieve(parseInt(currentSnippetId));
        int otherUser = codeSnippetRequestModel.getUserId();

        userRepoGateway.addChatId(thisUser, chatID);
        userRepoGateway.addChatId(otherUser, chatID);

        feedDSRepository.match(likeSnippetRequestModel.getFeedId());

        chatRepoGateway.save(chatRepoRequestModel);

        chatOutputBoundary.openChat(chatID, thisUser, otherUser);
    }
}
