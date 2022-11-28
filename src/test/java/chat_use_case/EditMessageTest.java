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

class EditMessageTest {

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
    void edit() throws IOException {
        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        ChatRequestModel requestModel = new ChatRequestModel(-1, "hello there", -1, -2, new Date());
        class fakePresenter implements ChatOutputBoundary {
            @Override
            public void addMessage(ChatResponseModel responseModel) {

            }

            @Override
            public void deleteMessage(int messageId) {

            }

            @Override
            public void editMessage(int messageId, String content) {

            }

            @Override
            public void replyMessage(ChatResponseModel responseModel, int replyToMessageId) {

            }

            @Override
            public void openChat(int chatId, int userId, int otherUser) {

            }

            @Override
            public void failView(String error) {

            }
        }
        EditMessageInputBoundary editMessage = new EditMessage(new fakePresenter(), messageRepoGateway);
        editMessage.edit(-1, requestModel.getContent());

        // Check if content for message has changed
        String actual = messageRepoGateway.getAllMessages().get(-1).getContent();
        String expected = requestModel.getContent();
        assertEquals(actual, expected);
        assertTrue(messageRepoGateway.getAllMessages().get(-1).isEdited());


    }
}