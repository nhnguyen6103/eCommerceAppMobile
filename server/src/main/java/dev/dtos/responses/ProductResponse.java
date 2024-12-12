package dev.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductResponse {
    private String  id;
    private String name;
    private String  category;
    private String  imageURL;
    private String  description;
    private Integer quantity;
    private Double  price;
}
