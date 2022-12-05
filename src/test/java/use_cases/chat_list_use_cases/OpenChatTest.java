package use_cases.chat_list_use_cases;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatOutputBoundary;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatResponseModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OpenChatTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void openChat() throws IOException {
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
                assertEquals(chatId, 1);
                assertEquals(userId, 1);
                assertEquals(otherUser, 2);
            }

            @Override
            public void failView(String error) {

            }
        }
        OpenChatInputBoundary openChatInputBoundary = new OpenChat(new fakePresenter());
        openChatInputBoundary.openChat(1, 1, 2);
    }
}