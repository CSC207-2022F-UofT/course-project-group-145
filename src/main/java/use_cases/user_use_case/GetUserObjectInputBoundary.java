package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoRequestModel;

import java.io.IOException;

public interface GetUserObjectInputBoundary {

    UserRepoRequestModel getUserObject(int userId) throws IOException;
}
