package entities;

import java.util.List;

public class CodeSnippetFactory {
    public CodeSnippet create(int id, int userId, String title, String fileUrl) {
        return new CodeSnippet(id, userId, title, fileUrl);
    }
}