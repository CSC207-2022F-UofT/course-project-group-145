package use_cases.feed_interaction_use_cases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller_presenter_gateway.feed_controller_presenter_gateway.FeedDSRepository;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedGatewayRequestModel;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedRepository;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.CurrentSnippetOutputBoundary;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.CurrentSnippetResponseModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import use_cases.feed_interaction_use_case.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentSnippetTest {

    @BeforeEach
    void setUp() throws IOException {
        // Create a feed to use to test
        FeedDSRepository feedDSRepository = new FeedRepository("feed.json");
        List<String> snippetIds = new ArrayList<>();
        snippetIds.add("1");
        FeedGatewayRequestModel feedGatewayRequestModel = new FeedGatewayRequestModel(snippetIds, new ArrayList<>(), new ArrayList<>(), -1, 1, "1");
        feedDSRepository.save(feedGatewayRequestModel);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Remove the feed from the JSON file after the test is done
        FeedDSRepository feedDSRepository = new FeedRepository("feed.json");
        Map<String, FeedGatewayRequestModel> feeds= new HashMap<>();
        FileWriter writer = new FileWriter("feed.json");
        Gson gson = new GsonBuilder().create();
        gson.toJson(feeds, writer);
        writer.close();
    }

    @Test
    void current() throws IOException {

        FeedDSRepository feedDSRepository = new FeedRepository("feed.json");
        class fakePresenter implements CurrentSnippetOutputBoundary {

            @Override
            public void getSnippet(CurrentSnippetResponseModel responseModel) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        }

        CurrentSnippetInputBoundary currentSnippetInputBoundary = new CurrentSnippetUseCase(feedDSRepository, new fakePresenter());

        // Check that the feed does not advance, it just sends the location of the current snippet.
        currentSnippetInputBoundary.current(new CurrentSnippetRequestModel("1"));
        int current = feedDSRepository.load("1").getCurr();
        assertEquals(-1, current);
    }
}
