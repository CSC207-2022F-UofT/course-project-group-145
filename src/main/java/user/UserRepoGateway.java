package user;

import java.io.IOException;
import java.util.List;
public interface UserRepoGateway {

    int getNumUsers();
    void save(UserRepoRequestModel requestModel) throws IOException;
    void delete(int userId) throws IOException;

    void addChatId(int userId, int chatId) throws IOException;

    void addFeedId(int userId, int feedId) throws IOException;

    List<Integer> getFeeds(int userId) throws IOException;

    UserRepoRequestModel getUser(int userId) throws IOException;
}
