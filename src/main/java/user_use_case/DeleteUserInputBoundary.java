package user_use_case;
import java.io.IOException;

public interface DeleteUserInputBoundary {
    void delete(int userId) throws IOException;
}
