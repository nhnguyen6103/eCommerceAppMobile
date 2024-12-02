package dev.exception;


import dev.dtos.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<?>> handlingRunTimeException(AppException e)
    {
        ApiResponse<?> apiResponse = e.getApiResponse();
        HttpStatus httpStatus = HttpStatus.valueOf(apiResponse.getStatus());
        return new ResponseEntity<>(apiResponse,httpStatus);
    }


}
