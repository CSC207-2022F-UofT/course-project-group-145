package use_cases.codesnippet_use_cases;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRequestModel;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;

import java.io.IOException;

public interface CodeSnippetListInputBoundary {
        CodeSnippetResponseModel create(CodeSnippetRequestModel requestModel) throws IOException;
        CodeSnippetResponseModel upload(CodeSnippetRequestModel requestModel);
        CodeSnippetResponseModel edit(int codeSnippetId, CodeSnippetResponseModel content);
        void delete(int codeSnippetId);
}
