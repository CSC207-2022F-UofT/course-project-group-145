package codesnippet;

import java.io.IOException;
import java.util.Map;

public interface CodeSnippetRepoGateway {
    int getNumCodeSnippets();

    void save(CodeSnippetRequestModel requestModel) throws IOException;

    CodeSnippetRequestModel retrieve (int codeSnippetId);

    Map<Integer, CodeSnippetRequestModel> getAllCodeSnippets();
}
