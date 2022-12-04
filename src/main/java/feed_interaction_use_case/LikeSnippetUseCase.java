package feed_interaction_use_case;

import chat.ChatRepoGateway;
import chat.ChatRepoRequestModel;
import codesnippet.CodeSnippetRepoGateway;
import codesnippet.CodeSnippetRequestModel;
import entities.Chat;
import entities.ChatFactory;
import entities.FeedFactory;
import feed.FeedDSRepository;
import feed.FeedGatewayResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class LikeSnippetUseCase implements LikeSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final ChatRepoGateway chatRepoGateway;
    final CodeSnippetRepoGateway codeSnippetRepoGateway;
    final FeedFactory feedFactory;
    final ChatFactory chatFactory;


    public LikeSnippetUseCase(FeedDSRepository feedDSRepository, ChatRepoGateway chatRepoGateway, CodeSnippetRepoGateway codeSnippetRepoGateway, FeedFactory feedFactory, ChatFactory chatFactory) {
        this.feedDSRepository = feedDSRepository;
        this.chatRepoGateway = chatRepoGateway;
        this.codeSnippetRepoGateway = codeSnippetRepoGateway;
        this.feedFactory = feedFactory;
        this.chatFactory = chatFactory;
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
        String currentSnippetId = feed.getSnippetIDs().get(feed.getCurr());
        CodeSnippetRequestModel codeSnippetRequestModel = codeSnippetRepoGateway.retrieve(parseInt(currentSnippetId));
        int otherUser = codeSnippetRequestModel.getUserId(); //

        feedDSRepository.match(likeSnippetRequestModel.getFeedId());



        // add chatID to the list of ChatIds of the two users.
        // retrieve Snippet from the SnippetRepository. Obtain the UserID from the CodeSnippetResponseModel.
        // Then retrieve the user from the user repository. Create the user and add the new chatID to its
        // list of chatIDs.

        // save chat to the repository
        // call presenter


    }
}
