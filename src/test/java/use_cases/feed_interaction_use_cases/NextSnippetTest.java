package use_cases.feed_interaction_use_cases;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedDSRepository;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedGatewayRequestModel;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedRepository;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.NextSnippetOutputBoundary;
import controller_presenter_gateway.feed_interaction_controller_presenter_gateway.NextSnippetResponseModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import use_cases.feed_interaction_use_case.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextSnippetTest {

    @BeforeEach
    void setUp() throws IOException {
        // Create a feed to use to test
        FeedDSRepository feedDSRepository = new FeedRepository("feed.json");
        List<String> snippetIds = new ArrayList<>();
        snippetIds.add("1");
        snippetIds.add("2");
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
    void next() throws IOException {

        FeedDSRepository feedDSRepository = new FeedRepository("feed.json");
        class fakePresenter implements NextSnippetOutputBoundary {

            @Override
            public void showNextSnippet(NextSnippetResponseModel responseModel) {

            }

            @Override
            public void prepareFailView(String message) {

            }
        }

        NextSnippetInputBoundary nextSnippetInputBoundary = new NextSnippetUseCase(feedDSRepository, new fakePresenter());

        // Check that the variable curr indeed increases, so that the feed advances.
        nextSnippetInputBoundary.next(new NextSnippetRequestModel("1"));
        int current = feedDSRepository.load("1").getCurr();
        assertEquals(0, current);
    }
}
