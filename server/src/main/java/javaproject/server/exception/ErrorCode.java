package javaproject.server.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    INVALID_ARGUMENT(0, "INVALID ARGUMENT",HttpStatus.BAD_REQUEST),
    USER_EXISTED(-1,"USER ALREADY EXISTED",HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(-2, "USER NOT EXISTED", HttpStatus.BAD_REQUEST),
    FIELD_NOT_EXISTED(-3, "FIELD NOT EXISTED", HttpStatus.BAD_REQUEST),
    WRONG_PASSWORD(-4,"WRONG PASSWORD", HttpStatus.BAD_REQUEST),
    EMPTY_FILE(-5, "FILE IS EMPTY",HttpStatus.BAD_REQUEST),
    CATEGORY_EXISTED(-6, "CATEGORY ALREADY EXISTED", HttpStatus.BAD_REQUEST),
    PRODUCT_EXISTED(-7,"PRODUCT ALREADY EXISTED", HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_EXISTED(-8,"PRODUCT NOT EXISTED", HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_EXISTED(-9, "CATEGORY NOT EXISTED", HttpStatus.BAD_REQUEST),
    CART_NOT_EXISTED(-10, "CART NOT EXISTED", HttpStatus.BAD_REQUEST),
    ORDER_NOT_EXISTED(-11, "ORDER NOT EXISTED", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(-12, "UNAUTHORIZED", HttpStatus.BAD_REQUEST),
    NOT_EXISTED_IN_CART(-13, "PRODUCT NOT EXISTED IN CART", HttpStatus.BAD_REQUEST),
    INVALID_REQUEST(-14,"INVALID REQUEST", HttpStatus.BAD_REQUEST)
    ;

    private final int returnCode;
    private final String message;
    private final HttpStatusCode status;

    ErrorCode(int returnCode, String message, HttpStatusCode status) {
        this.returnCode = returnCode;
        this.message = message;
        this.status = status;
    }
}
