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

    final LikeSnippetOutputBoundary outputBoundary;

    final ChatFactory chatFactory;

//    final CodeSnippetRepoGateway snippetRepoGateway;

    public LikeSnippetUseCase(FeedDSRepository feedDSRepository, FeedFactory feedFactory,
                              LikeSnippetOutputBoundary outputBoundary, ChatFactory chatFactory) {
        this.feedDSRepository = feedDSRepository;
        this.feedFactory = feedFactory;
        this.outputBoundary = outputBoundary;
        this.chatFactory = chatFactory;
//        this.snippetRepoGateway = snippetRepoGateway;
    }

    @Override
    public void like(String snippetID, LikeSnippetRequestModel likeSnippetRequestModel) throws IOException {
        // obtain code snippets to create a list of CodeSnippet objects to them pass into the FeedFactory
        // obtain matched code snippets to create a list of matched CodeSnippets

//        List<CodeSnippetResponseModel> snippetsInFeed snippetRepoGateway.getCodeSnippets(likeSnippetRequestModel.getSnippetIDs());

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


        // create a LikeSnippetResponseModel to be sent to the LikeSnippetOutputBoundary

        // make a call to the chat presenter passing in the id of the chat.


    }
}
