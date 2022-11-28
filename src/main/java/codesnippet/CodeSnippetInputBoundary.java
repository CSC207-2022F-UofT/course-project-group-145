package codesnippet;

import java.io.IOException;

public interface CodeSnippetInputBoundary {
        CodeSnippetResponseModel create(CodeSnippetRequestModel requestModel) throws IOException;
}
