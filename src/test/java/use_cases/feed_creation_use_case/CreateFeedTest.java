package use_cases.feed_creation_use_case;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRepoGateway;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;
import controller_presenter_gateway.feed_controller_presenter_gateway.*;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoRequestModel;
import entities.CodeSnippetFactory;
import entities.FeedFactory;
import entities.TagFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.feed_use_case.CreateFeedUseCase;
import use_cases.feed_use_case.CreateFeedUseCaseInputBoundary;
import use_cases.feed_use_case.CreateFeedUseCaseRequestModel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CreateFeedTest {
    private class FakeSnippetRepo implements CodeSnippetRepoGateway{
        private int num = 0;
        private Map<Integer, CodeSnippetResponseModel> storage = new HashMap<>();

        @Override
        public int getNumCodeSnippets() {
            return num;
        }

        @Override
        public void save(CodeSnippetResponseModel responseModel) throws IOException {
            this.storage.put(responseModel.getId(), responseModel);
            num ++;
        }

        @Override
        public void delete(int codeSnippetId) throws IOException {
        }

        @Override
        public CodeSnippetResponseModel retrieve(int codeSnippetId) {
            return storage.get(codeSnippetId);
        }

        @Override
        public Map<Integer, CodeSnippetResponseModel> getAllCodeSnippets() {
            return storage;
        }

        @Override
        public List<CodeSnippetResponseModel> getCodeSnippetsByUserId(int userId) {
            return null;
        }
    }

    private class FakeFeedRepo implements FeedDSRepository{
        Map<String, FeedGatewayRequestModel> storage = new HashMap<>();
        int num = 0;

        @Override
        public void save(FeedGatewayRequestModel request) throws IOException {
            storage.put(request.getFeedId(), request);
            num ++;
        }

        @Override
        public FeedGatewayResponseModel load(String id) {
            FeedGatewayRequestModel requestModel = storage.get(id);
            return new FeedGatewayResponseModel(requestModel.getSnippetIDs(), requestModel.getMatchedIDs(), requestModel.getTags(), requestModel.getCurr(), requestModel.getUserId());
        }

        @Override
        public void advanceFeed(String FeedId) throws IOException {

        }

        @Override
        public void match(String FeedId) throws IOException {

        }

        @Override
        public int numFeeds() {
            return num;
        }
    }

    private class FakeUserRepo implements UserRepoGateway{
        public int userID;
        public int feedID;
        @Override
        public int getNumUsers() {
            return 0;
        }

        @Override
        public Map<Integer, UserRepoRequestModel> getAllUsers() {
            return null;
        }

        @Override
        public void save(UserRepoRequestModel requestModel) throws IOException {

        }

        @Override
        public void delete(int userId) throws IOException {

        }

        @Override
        public void addChatId(int userId, int chatId) throws IOException {

        }

        @Override
        public void addFeedId(int userId, int feedId) throws IOException {
            this.userID = userId;
            this.feedID = feedId;
        }

        @Override
        public List<Integer> getFeeds(int userId) throws IOException {
            return null;
        }

        @Override
        public UserRepoRequestModel getUser(int userId) throws IOException {
            return null;
        }
    }

    private FakeSnippetRepo snippetRepo;

    @BeforeEach
    void setUp() throws IOException {
        // Create a fake snippet repository to provide snippets
        this.snippetRepo = new FakeSnippetRepo();
        this.snippetRepo.save(new CodeSnippetResponseModel(0, 0, "title0", "URL1", new Date()));
        this.snippetRepo.save(new CodeSnippetResponseModel(1, 0, "title1", "URL2", new Date()));
        this.snippetRepo.save(new CodeSnippetResponseModel(2, 0, "title2", "URL3", new Date()));
        assert (snippetRepo.getNumCodeSnippets() == 3);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Remove the feed from the JSON file after the test is done
        snippetRepo = null;
    }

    @Test
    public void ensureSuccessView(){
        int userId = 0;

        class FakePresenter implements CreateFeedOutputBoundary{

            @Override
            public void successView(CreateFeedResponseModel model) {
                assertEquals(model.getUserID(), userId);
            }

            @Override
            public void failView(String errDesc) {
                fail("Use case called failview");
            }
        }
        CreateFeedUseCase useCase = new CreateFeedUseCase(new FakePresenter(), new FakeFeedRepo(), snippetRepo, new FakeUserRepo(), new TagFactory(), new FeedFactory(), new CodeSnippetFactory());
        useCase.createFeed(new CreateFeedUseCaseRequestModel(userId, new ArrayList<String>(), 1));
    }

    @Test
    public void savedInfo(){
        int userId = 0;
        FakeFeedRepo feedRepo = new FakeFeedRepo();
        FakeUserRepo userRepo = new FakeUserRepo();
        class FakePresenter implements CreateFeedOutputBoundary{

            @Override
            public void successView(CreateFeedResponseModel model) {
            }

            @Override
            public void failView(String errDesc) {
            }
        }
        CreateFeedUseCase useCase = new CreateFeedUseCase(new FakePresenter(), feedRepo, snippetRepo, userRepo, new TagFactory(), new FeedFactory(), new CodeSnippetFactory());
        useCase.createFeed(new CreateFeedUseCaseRequestModel(userId, new ArrayList<String>(), snippetRepo.getNumCodeSnippets()));
        assertEquals(1, feedRepo.storage.size());

        FeedGatewayResponseModel model = feedRepo.load("1");
        assertEquals(snippetRepo.getNumCodeSnippets(), model.getSnippetIDs().size());
        assertEquals(0, model.getMatchedIDs().size());
        assertEquals(0, model.getCurr());
        assertEquals(userId, model.getUserId());

        assertEquals(1, userRepo.feedID);
        assertEquals(userRepo.userID, userId);

    }


}
