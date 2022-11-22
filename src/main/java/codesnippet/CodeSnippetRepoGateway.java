package codesnippet;

import entities.CodeSnippet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CodeSnippetRepoGateway {
    void save(CodeSnippetRequestModel requestModel) throws IOException;

    CodeSnippetResponseModel retrieve (int codeSnippetId) throws IOException;

    List<CodeSnippetResponseModel> getCodeSnippets(List<Integer> codeSnippetIds) throws IOException;

    Map<Integer, CodeSnippetResponseModel> getAllCodeSnippets() throws IOException;
}
