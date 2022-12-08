package entities;


import java.util.Date;

/**
 * Factory class that creates code snippets
 */
public class CodeSnippetFactory {
    /**
     * Creates a new code snippet
     * @param id id of code snippet
     * @param userId id of user that uploaded the snippet
     * @param title title of the snippet
     * @param fileUrl URL of the snippet
     * @param creationTime time of creation of the snippet, as a date object
     * @return a completed code snippet entity object
     */
    public CodeSnippet create(int id, int userId, String title, String fileUrl, Date creationTime) {
        return new CodeSnippet(id, userId, title, fileUrl, creationTime);
    }
}