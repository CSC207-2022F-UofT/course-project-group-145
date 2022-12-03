package codesnippet_use_case;

import codesnippet.CodeSnippetRequestModel;
import codesnippet.CodeSnippetResponseModel;

import java.io.IOException;

public interface CodeSnippetInputBoundary {
        CodeSnippetResponseModel create(CodeSnippetRequestModel requestModel) throws IOException;
}
