package codesnippet_use_cases;

import codesnippet.CodeSnippetRequestModel;
import codesnippet.CodeSnippetResponseModel;

import java.io.IOException;

public interface CodeSnippetListInputBoundary {
        CodeSnippetResponseModel create(CodeSnippetRequestModel requestModel) throws IOException;
        CodeSnippetResponseModel upload(CodeSnippetRequestModel requestModel);
        CodeSnippetResponseModel edit(int codeSnippetId, CodeSnippetResponseModel content);
        void delete(int codeSnippetId);
}
