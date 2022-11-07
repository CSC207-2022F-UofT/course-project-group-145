package entities;

import java.util.List;

public class CodeSnippetFactory {
    public CodeSnippet create(int userId, String title, String fileUrl) {
        return new CodeSnippet(userId, title, fileUrl)
    }
}