package use_cases.chat_list_use_cases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepoGateway;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepoRequestModel;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatRepository;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionOutputBoundary;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionResponseModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DeleteChatTest {

    @BeforeEach
    void setUp() throws IOException {
        // Create chat to use for testing
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
        ChatRepoRequestModel chat = new ChatRepoRequestModel(-1, new ArrayList<>(), false);
        chatRepoGateway.save(chat);
    }

    @AfterEach
    void tearDown() throws IOException {
        Gson gson = new GsonBuilder().create();
        // Hard remove the chat from JSON file after test done
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
        Map<Integer, ChatRepoRequestModel> chats = chatRepoGateway.getAllChats();
        chats.remove(-1);
        FileWriter writer1 = new FileWriter("chat.json");
        gson.toJson(chats, writer1);
        writer1.close();
    }

    @Test
    void delete() throws IOException {
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");

        class fakePresenter implements ChatDeletionOutputBoundary {

            @Override
            public void successView(ChatDeletionResponseModel responseModel) {

            }

            @Override
            public void failView(String error) {

            }

            public void openListChat(int userId) {

            }
        }

        DeleteChatInputBoundary deleteChat = new DeleteChat(new fakePresenter(), chatRepoGateway);
        deleteChat.delete(-1);
        boolean actual = chatRepoGateway.getAllChats().get(-1).isDeleted();
        assertTrue(actual);
    }
}