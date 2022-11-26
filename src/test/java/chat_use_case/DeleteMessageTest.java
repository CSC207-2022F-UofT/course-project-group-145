package chat_use_case;

import chat.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DeleteMessageTest {

    @BeforeEach
    void setUp() throws IOException {
        // Create a message to use to test
        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        MessageRepoRequestModel message = new MessageRepoRequestModel(-1, "hello", -1, -2, new Date(),
                new Date(), false, false, false, -1);
        messageRepoGateway.save(message);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Hard remove the message from JSON file after test done
        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        Map<Integer, MessageRepoRequestModel> messages = messageRepoGateway.getAllMessages();
        messages.remove(-1);
        FileWriter writer = new FileWriter("message.json");
        Gson gson = new GsonBuilder().create();
        gson.toJson(messages, writer);
        writer.close();
    }

    @Test
    void delete() throws IOException {
        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        class fakePresenter implements ChatOutputBoundary {
            @Override
            public void successView(ChatResponseModel responseModel) {

            }

            @Override
            public void failView(String error) {

            }
        }
        DeleteMessageInputBoundary deleteMessage = new DeleteMessage(new fakePresenter(), messageRepoGateway);

        // Check if message is deleted
        deleteMessage.delete(-1);
        boolean actual = messageRepoGateway.getAllMessages().get(-1).isDeleted();
        assertTrue(actual);
    }
}