package codesquad.util;

import codesquad.domain.result.Result;
import codesquad.exception.ApiException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandlerUtils {

    @ExceptionHandler(ApiException.class)
    public Result apiExceptionHandler() {
        return (new Result().fail("Handler Fail"));
    }
}
