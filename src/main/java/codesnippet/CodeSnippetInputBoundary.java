package codesnippet;

import java.io.IOException;

public interface CodeSnippetInputBoundary {
        CodeSnippetResponseModel create(CodeSnippetRequestModel requestModel) throws IOException;
        CodeSnippetResponseModel update(int codeSnippetId, CodeSnippetRequestModel requestModel) throws IOException;
        void delete(int codeSnippetId) throws IOException;
}
