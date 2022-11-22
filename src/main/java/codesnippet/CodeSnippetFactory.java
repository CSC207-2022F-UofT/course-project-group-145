package codesnippet;

import entities.CodeSnippet;

public interface CodeSnippetFactory {
    CodeSnippet create(String title, int userId, String fileUrl);
}
