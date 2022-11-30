package feed_interaction_use_case;

import entities.Chat;
import entities.ChatFactory;
import entities.FeedFactory;
import feed.FeedDSRepository;
import feed.FeedGatewayResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LikeSnippetUseCase implements LikeSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final FeedFactory feedFactory;
    final ChatFactory chatFactory;

//    final CodeSnippetRepoGateway snippetRepoGateway;

    public LikeSnippetUseCase(FeedDSRepository feedDSRepository, FeedFactory feedFactory, ChatFactory chatFactory) {
        this.feedDSRepository = feedDSRepository;
        this.feedFactory = feedFactory;
        this.chatFactory = chatFactory;
//        this.snippetRepoGateway = snippetRepoGateway;
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
        feedDSRepository.match(likeSnippetRequestModel.getFeedId());

//        List<String> newMatched = new ArrayList<>(feed.getMatchedIDs());
//        newMatched.add(snippetID);

        List<Integer> emptyList = new ArrayList<>();
        Chat newChat = chatFactory.create(emptyList);
        Chat.setNumChat(8); // set this to the ChatRepository's number of chats. 8 is a placeholder
        Integer chatID = newChat.getChatId();

        int thisUser = feed.getUserId();
        int otherUser; //

        // add chatID to the list of ChatIds of the two users.
        // retrieve Snippet from the SnippetRepository. Obtain the UserID from the CodeSnippetResponseModel.
        // Then retrieve the user from the user repository. Create the user and add the new chatID to its
        // list of chatIDs.

        // make a call to the chat presenter passing in the id of the chat.


    }
}
