package user;

public interface UserOutputBoundary {
    void successView(UserResponseModel responseModel);

    void failView(String error);
}
