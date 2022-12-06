package controller_presenter_gateway.user_controller_presenter_gateway;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserRepoGateway {

    int getNumUsers();

    Map<Integer, UserRepoRequestModel> getAllUsers();
    void save(UserRepoRequestModel requestModel) throws IOException;
    void delete(int userId) throws IOException;

    void addChatId(int userId, int chatId) throws IOException;

    void addFeedId(int userId, int feedId) throws IOException;

    List<Integer> getFeeds(int userId) throws IOException;

    UserRepoRequestModel getUser(int userId) throws IOException;
}
