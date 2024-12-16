package javaproject.server.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CartResponse {
    private String cartID;
    private Integer quantity;
    private List<CartItemsResponse> listItems;
}
