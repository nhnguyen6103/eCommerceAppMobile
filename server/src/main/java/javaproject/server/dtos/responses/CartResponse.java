package javaproject.server.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CartResponse {
    private String cartID;
    private Integer quantity;
    private List<CartItemsResponse> listItems;

    public CartResponse(String cartID, Integer quantity, List<CartItemsResponse> listItems) {
        this.cartID = cartID;
        this.quantity = quantity;
        this.listItems = listItems;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<CartItemsResponse> getListItems() {
        return listItems;
    }

    public void setListItems(List<CartItemsResponse> listItems) {
        this.listItems = listItems;
    }
}

