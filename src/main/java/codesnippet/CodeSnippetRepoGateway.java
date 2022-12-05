package codesnippet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CodeSnippetRepoGateway {
    int getNumCodeSnippets();

    void save(CodeSnippetResponseModel responseModel) throws IOException;

    void delete(int codeSnippetId) throws IOException;

    CodeSnippetResponseModel retrieve (int codeSnippetId);

    Map<Integer, CodeSnippetResponseModel> getAllCodeSnippets();

    List<CodeSnippetResponseModel> getCodeSnippetsByUserId(int userId);
}
