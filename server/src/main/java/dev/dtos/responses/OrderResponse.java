package dev.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderResponse {
    private String id;
    private Double total;
    private String status;
    private String shipping_address;
    private Date createdAt;
    private Date updatedAt;
    private String paymentMethod;
    private String shippingMethod;
    private List<OrderItemsResponse> orderedItems;
}
