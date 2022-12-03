package use_cases.chat_use_cases;

public interface EditMessageInputBoundary {
    void edit(int messageId, String content);
}
