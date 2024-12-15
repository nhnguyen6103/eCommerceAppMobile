package javaproject.server.exception;


import javaproject.server.dtos.responses.ApiResponse;

public class AppException extends RuntimeException {
    private final ApiResponse<?> apiResponse;

    //Constructor
    public AppException(int status, String message, int returnCode) {
        super(message);
        this.apiResponse = ApiResponse.builder()
                .status(status)
                .message(message)
                .returnCode(returnCode)
                .build();
    }

    public AppException(ErrorCode er)
    {
        super(er.getMessage());
        this.apiResponse = ApiResponse.builder()
                .status(er.getStatus().value())
                .message(er.getMessage())
                .returnCode(er.getReturnCode())
                .build();
    }


    public ApiResponse<?> getApiResponse() {
        return apiResponse;
    }
}
