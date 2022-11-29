package codesnippet;

import entities.CodeSnippet;

public class CodeSnippetFactory {
    public CodeSnippet create(int id, String title, int userId, String fileUrl) {
        return new CodeSnippet(id, userId, title, fileUrl);
    }
}