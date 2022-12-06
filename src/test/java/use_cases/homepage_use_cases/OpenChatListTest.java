package use_cases.homepage_use_cases;

import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionOutputBoundary;
import controller_presenter_gateway.chat_list_controller_presenter_gateway.ChatDeletionResponseModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OpenChatListTest {

    @Test
    void openList() throws IOException {
        class fakePresenter implements ChatDeletionOutputBoundary {
            @Override
            public void successView(ChatDeletionResponseModel responseModel) {

            }

            @Override
            public void failView(String error) {

            }

            @Override
            public void openChatList(int userId) {
                assertEquals(userId, 0);
            }
        }
        OpenChatListInputBoundary openChatList = new OpenChatList(new fakePresenter());
        openChatList.openList(0);
    }
}