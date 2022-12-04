package use_cases.chat_use_cases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller_presenter_gateway.chat_controller_presenter_gateway.*;
import entities.MessageFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SendMessageTest {

    @BeforeEach
    void setUp() throws IOException {
        // Create chat to use for testing
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
        ChatRepoRequestModel chat = new ChatRepoRequestModel(-1, new ArrayList<>(), false);
        chatRepoGateway.save(chat);

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
        int numMessages = messageRepoGateway.getNumMessages();
        messages.remove(numMessages - 1);
        messages.remove(-1);
        FileWriter writer = new FileWriter("message.json");
        Gson gson = new GsonBuilder().create();
        gson.toJson(messages, writer);
        writer.close();

        // Hard remove the chat from JSON file after test done
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
        Map<Integer, ChatRepoRequestModel> chats = chatRepoGateway.getAllChats();
        chats.remove(-1);
        FileWriter writer1 = new FileWriter("chat.json");
        gson.toJson(chats, writer1);
        writer1.close();
    }

    @Test
    void send() throws IOException {
        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
        class fakePresenter implements ChatOutputBoundary {
            @Override
            public void addMessage(ChatResponseModel responseModel) {

            }

            @Override
            public void editMessage(int messageId, String content) {

            }

            @Override
            public void replyMessage(ChatResponseModel responseModel, int replyToMessageId) {

            }

            @Override
            public void deleteMessage(int messageId) {

            }

            @Override
            public void openChat(int chatId, int userId, int otherUser) {

            }

            @Override
            public void failView(String error) {

            }
        }
        SendMessageInputBoundary sendMessage = new SendMessage(new MessageFactory(), new fakePresenter(), messageRepoGateway,
                chatRepoGateway);
        ChatRequestModel requestModel = new ChatRequestModel(-1, "hello", -1, -2, new Date());
        sendMessage.send(requestModel);

        // Check if message exists in repository
        assertTrue(messageRepoGateway.getAllMessages().containsKey(messageRepoGateway.getNumMessages() - 1));

        List<Integer> messageId = new ArrayList<>();
        messageId.add(messageRepoGateway.getNumMessages() - 1);
        List<MessageRepoRequestModel> message = messageRepoGateway.getMessages(messageId);

        // Check if message is correct in repository
        assertEquals(requestModel.getContent(), message.get(0).getContent());
        assertNotNull(message.get(0).getSendTime());
        assertEquals(requestModel.getSendTime(), message.get(0).getSendTime());
        assertEquals(requestModel.getAuthor(), message.get(0).getAuthor());
        assertEquals(requestModel.getReceiver(), message.get(0).getReceiver());
    }

    @Test
    void reply() throws IOException {
        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
        class fakePresenter implements ChatOutputBoundary {
            @Override
            public void addMessage(ChatResponseModel responseModel) {

            }

            @Override
            public void editMessage(int messageId, String content) {

            }

            @Override
            public void replyMessage(ChatResponseModel responseModel, int replyToMessageId) {

            }

            @Override
            public void deleteMessage(int messageId) {

            }

            @Override
            public void openChat(int chatId, int userId, int otherUser) {

            }

            @Override
            public void failView(String error) {

            }
        }
        SendMessageInputBoundary sendMessage = new SendMessage(new MessageFactory(), new fakePresenter(), messageRepoGateway,
                chatRepoGateway);
        ChatRequestModel requestModel = new ChatRequestModel(-1, "hello", -1, -2, new Date());
        sendMessage.reply(requestModel, -1);

        // Check if message exists in repository
        assertTrue(messageRepoGateway.getAllMessages().containsKey(messageRepoGateway.getNumMessages() - 1));

        List<Integer> messageId = new ArrayList<>();
        messageId.add(messageRepoGateway.getNumMessages() - 1);
        List<MessageRepoRequestModel> message = messageRepoGateway.getMessages(messageId);

        // Check if message is correct in repository
        assertEquals(requestModel.getContent(), message.get(0).getContent());
        assertNotNull(message.get(0).getSendTime());
        assertEquals(requestModel.getSendTime(), message.get(0).getSendTime());
        assertEquals(requestModel.getAuthor(), message.get(0).getAuthor());
        assertEquals(requestModel.getReceiver(), message.get(0).getReceiver());

        // Check if reply has been added to message
        MessageRepoRequestModel mes = messageRepoGateway.getAllMessages().get(-1);
        assertEquals(mes.getReplyId(), message.get(0).getMessageId());
    }
}