package entities;


import java.util.Date;

public class CodeSnippetFactory {
    public CodeSnippet create(int id, int userId, String title, String fileUrl, Date creationTime) {
        return new CodeSnippet(id, userId, title, fileUrl, creationTime);
    }
}